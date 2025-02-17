package org.adorsis.management.api;

public class UrlMappings {
    public static class ImportEndpointsNames {
        public static final String ROOT = "import";
        public static final String IMPORT_ALL_EMPLOYEES = "all";
    }

    public static class EmployeeApi {
        public static final String ROOT = "employee";
        public static final String CREATE_EMPLOYEE = "new";
        public static final String GET_EMPLOYEE = "id";
        public static final String GET_EMPLOYEES_BETWEEN_AGES = "between-ages";
        public static final String EMPLOYEES_BY_SALARY_DESC = "by-salary-desc";
        public static final String EMPLOYEES_BY_NAME_ASC = "by-name-desc";
        public static final String DELETE_EMPLOYEE = "id";
    }
}
