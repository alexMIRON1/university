package com.botscrew.test.university.university.model.repository;

import com.botscrew.test.university.university.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * allow us working with department table {@link Department}
 *
 * @author Oleksandr Myronenko
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    /**
     * using for finding head of department from table by department name
     *
     * @param departmentName {@link Department} department's name
     * @return name head of department
     */
    String findHeadOfDepartmentByDepartmentName(String departmentName);

    /**
     * using for finding count of lectors by department name from table
     *
     * @param departmentName department name
     * @return count of lectors
     */
    @Query("SELECT COUNT(l) FROM Department d JOIN d.lectors l WHERE d.departmentName=:departmentName")
    Integer getCountLectorsByDepartmentName(String departmentName);

    /**
     * using for finding any information that contains input
     *
     * @param input user's input
     * @return matching information
     */
    @Query("SELECT d.departmentName FROM Department d WHERE d.departmentName LIKE %:input%" +
            " UNION SELECT d.headOfDepartment FROM Department d WHERE d.headOfDepartment LIKE %:input%" +
            " UNION SELECT l.lectorFullName FROM Lector l WHERE l.lectorFullName LIKE %:input%" +
            " UNION SELECT l.degree FROM Lector l WHERE l.degree LIKE %:input%")
    List<String> globalSearchByInput(String input);
}
