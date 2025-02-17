package org.adorsis.management.api.employee_api;


import org.adorsis.management.api.UrlMappings;
import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.*;
import org.adorsis.management.service.EmployeesCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UrlMappings.EmployeeApi.ROOT)
public class EmployeeApi implements EmployeeApiSpecification{
    private final EmployeesCRUDService employeesCRUDService;

    public EmployeeApi(EmployeesCRUDService employeesCRUDService) {
        this.employeesCRUDService = employeesCRUDService;
    }

    @Override
    public ResponseEntity<EmployeesImportResponseDTO> createEmployee(EmployeeCreationRequestDTO employee) {
        employeesCRUDService.createEmployee(employee);
        return ResponseEntity.ok(new EmployeesImportResponseDTO("works"));
    }

    @Override
    public ResponseEntity<EmployeeFetchingResponseDTO> getEmployee(EmployeeFetchingRequestDTO dto) {
        Optional<EmployeeFetchingResponseDTO> employee = employeesCRUDService.getEmployee(dto);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesBetweenAges(EmployeesBetweenAgesFetchingRequestDTO dto) {
        List<EmployeeFetchingResponseDTO> employee = employeesCRUDService.getEmployeesBetweenAges(dto);
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesBySalaryDesc() {
        List<EmployeeFetchingResponseDTO> employee = employeesCRUDService.getEmployeesOrderedDescBySalary();
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesByNameAsc() {
        List<EmployeeFetchingResponseDTO> employee = employeesCRUDService.getEmployeesOrderedAscByName();
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<EmployeeDeletionResponseDTO> deleteEmployee(EmployeeDeletionRequestDTO dto) {
        employeesCRUDService.deleteEmployee(dto);
        return ResponseEntity.ok().build();
    }
}
