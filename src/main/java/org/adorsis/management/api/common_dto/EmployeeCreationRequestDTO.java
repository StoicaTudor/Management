package org.adorsis.management.api.common_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeCreationRequestDTO(
        @JsonProperty(Constants.EmployeeDTOFieldsNames.FIRST_NAME) String firstName,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.LAST_NAME) String lastName,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.AGE) int age,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.PERSONAL_NUMBER) String personalNumber,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.ANNUAL_INCOME) double annualIncome,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.JOB_DESCRIPTION) String job,
        @JsonProperty(Constants.EmployeeDTOFieldsNames.DEPARTMENT) String department
) {
}