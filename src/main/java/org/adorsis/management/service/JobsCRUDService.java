package org.adorsis.management.service;

import org.adorsis.management.entities.Job;
import org.adorsis.management.repository.JobsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobsCRUDService {
    private final JobsRepository jobsRepository;

    public JobsCRUDService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public void createJobs(List<Job> jobs) {
        jobsRepository.saveAll(jobs);
        jobsRepository.flush();
    }

    public Map<String, Job> getJobNameToJobMap() {
        return jobsRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Job::getName, job -> job));
    }
}
