package org.adorsis.management.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String personalNumber;
    private double annualIncome;

    @OneToOne
    @JoinColumn(name = "job_id") // This ensures the job relationship is mapped correctly
    private Job job;

    @ManyToMany
    @JoinTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments;

    public Employee() {
    }

    public Employee(
            Long id,
            String firstName,
            String lastName,
            int age,
            String personalNumber,
            double annualIncome,
            Job job,
            List<Department> departments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personalNumber = personalNumber;
        this.annualIncome = annualIncome;
        this.job = job;
        this.departments = departments;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public Job getJob() {
        return job;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
