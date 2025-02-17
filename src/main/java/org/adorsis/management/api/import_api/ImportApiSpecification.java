package org.adorsis.management.api.import_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.adorsis.management.api.UrlMappings;
import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.EmployeesImportResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "ImportApiSpecification", description = "API entrypoint for import operations")
public interface ImportApiSpecification {
    @Operation(
            summary = "Imports all employees.",
            description = "Imports all employees supplied via the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getInformation 200")
    })
    @PostMapping(
            value = UrlMappings.ImportEndpointsNames.IMPORT_ALL_EMPLOYEES,
            produces = "application/json"
    )
    ResponseEntity<EmployeesImportResponseDTO> importAllEmployees(final @RequestBody List<EmployeeCreationRequestDTO> employees);
}
