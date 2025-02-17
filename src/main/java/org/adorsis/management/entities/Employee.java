package org.adorsis.management.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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
    private Job job;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Department> departments;
}
