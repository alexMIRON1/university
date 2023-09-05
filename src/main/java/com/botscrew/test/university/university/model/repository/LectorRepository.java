package com.botscrew.test.university.university.model.repository;

import com.botscrew.test.university.university.model.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * allow us working with lector table {@link Lector}
 *
 * @author Oleksandr Myronenko
 */
@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    /**
     * using find for each lector degree how many lectors in department name from table
     *
     * @param departmentName department name
     * @return list of objects
     */
    @Query("SELECT l.degree + COUNT(l) FROM Lector l JOIN l.departments d " +
            "WHERE d.departmentName=:departmentName GROUP BY l.degree")
    List<Object[]> findLectorDegreeCountByDepartmentName(String departmentName);

    /**
     * using find average salary for lectors by department name from table
     *
     * @param departmentName department name
     * @return average salary
     */
    @Query("SELECT AVG(l.salary) FROM Lector l JOIN l.departments d " +
            "WHERE d.departmentName=:departmentName")
    Double getAverageSalaryByDepartment(String departmentName);
}
