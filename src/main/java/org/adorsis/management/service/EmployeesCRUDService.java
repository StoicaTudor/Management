package org.adorsis.management.service;

import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.*;
import org.adorsis.management.entities.Department;
import org.adorsis.management.entities.Employee;
import org.adorsis.management.entities.Job;
import org.adorsis.management.mappers.EmployeesMappers;
import org.adorsis.management.repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EmployeesCRUDService {
    private final EmployeesRepository employeesRepository;
    private final DepartmentsCRUDService departmentsCRUDService;
    private final JobsCRUDService jobsCRUDService;

    public EmployeesCRUDService(
            EmployeesRepository employeesRepository,
            DepartmentsCRUDService departmentsCRUDService,
            JobsCRUDService jobsCRUDService) {
        this.employeesRepository = employeesRepository;
        this.departmentsCRUDService = departmentsCRUDService;
        this.jobsCRUDService = jobsCRUDService;
    }

    public Optional<EmployeeDeletionResponseDTO> deleteEmployee(EmployeeDeletionRequestDTO dto) {
        employeesRepository.deleteById(dto.id());
        return Optional.of(new EmployeeDeletionResponseDTO());
    }

    public List<EmployeeFetchingResponseDTO> getEmployeesBetweenAges(EmployeesBetweenAgesFetchingRequestDTO dto) {
        return employeesRepository.getEmployeeByAgeAfterAndAgeBefore(dto.ageAfter(), dto.ageBefore())
                .stream()
                .map(EmployeesMappers::toEmployeeFetchingResponseDTO)
                .toList();
    }

    public List<EmployeeFetchingResponseDTO> getEmployeesOrderedDescBySalary() {
        return employeesRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getAnnualIncome).reversed())
                .map(EmployeesMappers::toEmployeeFetchingResponseDTO)
                .toList();
    }

    public List<EmployeeFetchingResponseDTO> getEmployeesOrderedAscByName() {
        return employeesRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .map(EmployeesMappers::toEmployeeFetchingResponseDTO)
                .toList();
    }


    public Optional<EmployeeFetchingResponseDTO> getEmployee(EmployeeFetchingRequestDTO dto) {
        Optional<Employee> employee = employeesRepository.getEmployeeById(dto.id());
        return employee.map(EmployeesMappers::toEmployeeFetchingResponseDTO);
    }

    @Transactional
    public Long createEmployee(EmployeeCreationRequestDTO dto) {
        Map<String, Job> jobNameToJobMap = jobsCRUDService.getJobNameToJobMap();
        Map<String, Department> departmentNameToDepartmentMap = departmentsCRUDService.getDepartmentNameToDepartmentMap();

        Optional<Employee> employee = EmployeesMappers.toEmployee(dto, jobNameToJobMap, departmentNameToDepartmentMap);

        if (employee.isEmpty())
            return 0L;

        employeesRepository.save(employee.get());
        return 0L;
    }

    @Transactional
    public List<Long> createEmployees(List<EmployeeCreationRequestDTO> employeesDTOs) {
        Map<String, Job> jobNameToJobMap = jobsCRUDService.getJobNameToJobMap();
        Map<String, Department> departmentNameToDepartmentMap = departmentsCRUDService.getDepartmentNameToDepartmentMap();

        List<Employee> employees = employeesDTOs.stream()
                .map(dto -> EmployeesMappers.toEmployee(dto, jobNameToJobMap, departmentNameToDepartmentMap))
                .flatMap(Optional::stream)
                .toList();


        employeesRepository.saveAll(employees);
        employeesRepository.flush();
        return Collections.emptyList();
    }
}
