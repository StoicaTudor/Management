package org.adorsis.management.init_jobs;

import org.adorsis.management.entities.Department;
import org.adorsis.management.entities.Job;
import org.adorsis.management.service.DepartmentsCRUDService;
import org.adorsis.management.service.JobsCRUDService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class DatabasePopulatingService implements ApplicationRunner {
    private final static List<String> DEFAULT_DEPARTMENTS = List.of(
            "Softwareentwicklung",
            "Projektmanagement",
            "Human Resources"
    );

    private final static List<String> DEFAULT_JOBS = List.of(
            "Backend-Entwickler",
            "Projektmanagerin",
            "Frontend-Entwickler",
            "Recruiterin",
            "Frontend-Entwicklerin",
            "Recruiter"
    );

    private final JobsCRUDService jobsCRUDService;
    private final DepartmentsCRUDService departmentsCRUDService;

    public DatabasePopulatingService(
            JobsCRUDService jobsCRUDService,
            DepartmentsCRUDService departmentsCRUDService) {
        this.jobsCRUDService = jobsCRUDService;
        this.departmentsCRUDService = departmentsCRUDService;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        addNonExistentDepartments();
        addNonExistentJobs();
    }
    
    private void addNonExistentDepartments() {
        Map<String, Department> departmentNameToDepartmentMap = departmentsCRUDService.getDepartmentNameToDepartmentMap();
        List<Department> departmentsToAdd = DEFAULT_DEPARTMENTS.stream()
                .filter(departmentName -> departmentNameToDepartmentMap.get(departmentName) == null)
                .map(departmentName -> new Department(null,departmentName, Collections.emptyList()))
                .toList();

        departmentsCRUDService.createDepartments(departmentsToAdd);
    }

    private void addNonExistentJobs() {
        Map<String, Job> jobNameToJobMap = jobsCRUDService.getJobNameToJobMap();
        List<Job> jobsToAdd = DEFAULT_JOBS.stream()
                .filter(jobName -> jobNameToJobMap.get(jobName) == null)
                .map(jobName -> new Job(null, jobName))
                .toList();

        jobsCRUDService.createJobs(jobsToAdd);
    }
}
