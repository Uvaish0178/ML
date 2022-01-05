package com.uvaish.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(mappedBy = "supervisor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name="supId",nullable = false)
//    private long supId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dob;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "year_of_passing")
    private Integer yearOfPassing;

    @Column(name = "percentage")
    private Double percentage;

    @Column(name = "employment_history")
    private String employmentHistory;

    @Column(name = "designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates = new ArrayList<Employee>();
}
