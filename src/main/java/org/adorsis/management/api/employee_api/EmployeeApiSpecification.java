package org.adorsis.management.api.employee_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.adorsis.management.api.UrlMappings;
import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "EmployeeApiSpecification", description = "API entrypoint for employee operations")
public interface EmployeeApiSpecification {
    @Operation(
            summary = "Creates 1 employees.",
            description = "Creates 1 employees.")
    @PostMapping(
            value = UrlMappings.EmployeeApi.CREATE_EMPLOYEE,
            produces = "application/json"
    )
    ResponseEntity<EmployeesImportResponseDTO> createEmployee(final @RequestBody EmployeeCreationRequestDTO employee);

    @Operation(
            summary = "Fetches employees by ID.",
            description = "Fetches employees by ID.")
    @GetMapping(
            value = UrlMappings.EmployeeApi.GET_EMPLOYEE,
            produces = "application/json"
    )
    ResponseEntity<EmployeeFetchingResponseDTO> getEmployee(final @ModelAttribute EmployeeFetchingRequestDTO dto);

    @Operation(
            summary = "Fetches employees between ages",
            description = "Fetches employees between ages")
    @GetMapping(
            value = UrlMappings.EmployeeApi.GET_EMPLOYEES_BETWEEN_AGES,
            produces = "application/json"
    )
    ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesBetweenAges(final @ModelAttribute EmployeesBetweenAgesFetchingRequestDTO dto);

    @Operation(
            summary = "Fetches employees DESC based on salary",
            description = "etches employees DESC based on salary")
    @GetMapping(
            value = UrlMappings.EmployeeApi.EMPLOYEES_BY_SALARY_DESC,
            produces = "application/json"
    )
    ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesBySalaryDesc();

    @Operation(
            summary = "Fetches employees ASC based on name",
            description = "etches employees ASC based on name")
    @GetMapping(
            value = UrlMappings.EmployeeApi.EMPLOYEES_BY_NAME_ASC,
            produces = "application/json"
    )
    ResponseEntity<List<EmployeeFetchingResponseDTO>> getEmployeesByNameAsc();
    
    @Operation(
            summary = "Deletes employee by ID.",
            description = "Deletes employee by ID.")
    @DeleteMapping(
            value = UrlMappings.EmployeeApi.GET_EMPLOYEE,
            produces = "application/json"
    )
    ResponseEntity<EmployeeDeletionResponseDTO> deleteEmployee(final @ModelAttribute EmployeeDeletionRequestDTO dto);
}
