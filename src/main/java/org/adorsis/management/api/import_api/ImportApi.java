package org.adorsis.management.api.import_api;

import org.adorsis.management.api.UrlMappings;
import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;
import org.adorsis.management.api.dto.EmployeesImportResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.ImportEndpointsNames.ROOT)
public class ImportApi implements ImportApiSpecification {
    @Override
    public ResponseEntity<EmployeesImportResponseDTO> importAllEmployees(List<EmployeeCreationRequestDTO> employees) {
        return ResponseEntity.ok(new EmployeesImportResponseDTO("works"));
    }
}
