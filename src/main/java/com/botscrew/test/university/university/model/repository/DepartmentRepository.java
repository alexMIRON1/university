package com.botscrew.test.university.university.model.repository;

import com.botscrew.test.university.university.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * allow us working with department table {@link Department}
 *
 * @author Oleksandr Myronenko
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
