package com.botscrew.test.university.university.model.repository;

import com.botscrew.test.university.university.model.entity.Department;
import com.botscrew.test.university.university.model.entity.DepartmentName;
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
    @Query("SELECT d.headOfDepartment FROM Department d WHERE d.departmentName=:departmentName")
    String findHeadOfDepartmentByDepartmentName(DepartmentName departmentName);

    /**
     * using for finding count of lectors by department name from table
     *
     * @param departmentName department name
     * @return count of lectors
     */
    @Query("SELECT COUNT(l) FROM Department d JOIN d.workingLectors l WHERE d.departmentName=:departmentName")
    Integer getCountLectorsByDepartmentName(DepartmentName departmentName);

    /**
     * using for finding any information that contains input
     *
     * @param input user's input
     * @return matching information
     */
    @Query(value = "SELECT d.department_name FROM university.department d WHERE d.department_name ILIKE %:input%" +
            " UNION SELECT d.head_of_department FROM university.department d WHERE d.head_of_department ILIKE %:input%" +
            " UNION SELECT l.lector_full_name FROM university.lector l WHERE l.lector_full_name ILIKE %:input%" +
            " UNION SELECT l.lector_degree FROM university.lector l WHERE l.lector_degree ILIKE %:input%", nativeQuery = true)
    List<String> globalSearchByInput(String input);
}
