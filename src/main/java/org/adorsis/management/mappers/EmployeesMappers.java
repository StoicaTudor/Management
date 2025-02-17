package org.adorsis.management.mappers;

import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.EmployeeFetchingResponseDTO;
import org.adorsis.management.entities.Department;
import org.adorsis.management.entities.Employee;
import org.adorsis.management.entities.Job;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeesMappers {
    public static Optional<Employee> toEmployee(
            EmployeeCreationRequestDTO dto,
            Map<String, Job> jobNameToJobMap,
            Map<String, Department> departmentNameToDepartmentMap) {
        Job job = jobNameToJobMap.get(dto.job());
        Department department = departmentNameToDepartmentMap.get(dto.department());

        if (job == null || department == null)
            return Optional.empty();

        Employee employee = new Employee(
                0L,
                dto.firstName(),
                dto.lastName(),
                dto.age(),
                dto.personalNumber(),
                dto.annualIncome(),
                job,
                List.of(department)
        );
        employee.getDepartments().getFirst().getEmployees().add(employee);

        return Optional.of(employee);
    }

    public static EmployeeFetchingResponseDTO toEmployeeFetchingResponseDTO(Employee employee) {
        return new EmployeeFetchingResponseDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getPersonalNumber(),
                employee.getAnnualIncome(),
                employee.getJob().getName(),
                employee.getDepartments().stream().map(Department::getName).toList()
        );
    }
}
