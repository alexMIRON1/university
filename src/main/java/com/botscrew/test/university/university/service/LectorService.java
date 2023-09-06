package com.botscrew.test.university.university.service;

import com.botscrew.test.university.university.model.entity.Department;
import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.entity.Lector;
import com.botscrew.test.university.university.model.entity.LectorDegree;
import com.botscrew.test.university.university.model.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * responsible for main business operation with {@link Lector}
 *
 * @author Oleksandr Myronenko
 */
@Service
@RequiredArgsConstructor
public class LectorService {
    private final LectorRepository lectorRepository;

    /**
     * show statistics by department name
     *
     * @param departmentName department name {@link Department}
     * @return map where key - lector's degree, value - count of lectors
     */
    public Map<LectorDegree, Long> showStatisticsByDepartmentName(DepartmentName departmentName) {
        Map<LectorDegree, Long> statistics = new HashMap<>();
        List<Object[]> resultFromDatabase = lectorRepository.findLectorDegreeCountByDepartmentName(departmentName);
        for (Object[] objects : resultFromDatabase) {
            statistics.put((LectorDegree) objects[0], (Long) objects[1]);
        }
        return statistics;
    }

    /**
     * get average salary for lectors by department name
     *
     * @param departmentName department name
     * @return double value average salary
     */
    public Double getAverageSalaryByDepartmentName(DepartmentName departmentName) {
        return lectorRepository.getAverageSalaryByDepartment(departmentName);
    }
}
