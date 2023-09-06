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
@Table(name = "department", schema = "university")
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "department_name")
    private DepartmentName departmentName;

    @Column(name = "head_of_department")
    private String headOfDepartment;

    @ManyToMany
    @JoinTable(name = "department_lector", joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"), schema = "university")
    private Set<Lector> workingLectors;
}
