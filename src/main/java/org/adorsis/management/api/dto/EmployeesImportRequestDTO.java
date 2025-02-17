package org.adorsis.management.api.dto;

import org.adorsis.management.api.common_dto.EmployeeCreationRequestDTO;

import java.util.List;

public record EmployeesImportRequestDTO(List<EmployeeCreationRequestDTO> employees) {
}
