package com.botscrew.test.university.university.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * entity for table lector
 *
 * @author Oleksandr Myronenko
 */
@Entity
@Table(name = "lector")
@Getter
@Setter
@NoArgsConstructor
public class Lector {
    @Id
    private Long id;
    @Column(name = "lector_full_name")
    private String lectorFullName;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "degree")
    private Degree degree;
    @ManyToMany(mappedBy = "workingLectors")
    private Set<Department> departments;

}
