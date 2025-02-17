package org.adorsis.management.service;

import org.adorsis.management.entities.Department;
import org.adorsis.management.repository.DepartmentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentsCRUDService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsCRUDService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public void createDepartments(List<Department> departments) {
        departmentsRepository.saveAll(departments);
        departmentsRepository.flush();
    }
    
    public Map<String, Department> getDepartmentNameToDepartmentMap() {
        return departmentsRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Department::getName, department -> department));
    }
}
