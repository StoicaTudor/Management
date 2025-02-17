package org.adorsis.management.repository;

import org.adorsis.management.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getEmployeeByAgeAfterAndAgeBefore(int ageAfter, int ageBefore);
}
