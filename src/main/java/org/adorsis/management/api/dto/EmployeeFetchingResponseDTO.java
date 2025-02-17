package org.adorsis.management.api.dto;

public record EmployeeFetchingResponseDTO(
        Long id,
        String firstName,
        String lastName,
        int age,
        String personalNumber,
        double annualIncome,
        String job,
        java.util.List<String> department) {
}
