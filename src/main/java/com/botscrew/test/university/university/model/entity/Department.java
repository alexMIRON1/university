package com.botscrew.test.university.university.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * entity for department table
 *
 * @author Oleksandr Myronenko
 */
@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    private Long id;
    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "head_of_department")
    private String headOfDepartment;

    @ManyToMany
    @JoinTable(name = "department_lector", joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> workingLectors;
}
