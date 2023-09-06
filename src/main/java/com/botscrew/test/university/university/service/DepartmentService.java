package com.botscrew.test.university.university.service;

import com.botscrew.test.university.university.model.entity.Department;
import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * responsible for main business operation with {@link Department}
 *
 * @author Oleksandr Myronenko
 */
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    /**
     * using to find department head name by department name
     *
     * @param departmentName {@link Department} name
     * @return department head name
     */
    public String getDepartmentHeadNameByDepartmentName(DepartmentName departmentName) {
        return departmentRepository.findHeadOfDepartmentByDepartmentName(departmentName);
    }

    /**
     * using to get count lectors by department name
     *
     * @param departmentName department name
     * @return count of lectors
     */
    public Integer getCountLectorsByDepartmentName(DepartmentName departmentName) {
        return departmentRepository.getCountLectorsByDepartmentName(departmentName);
    }

    /**
     * using for global searching by some user input
     *
     * @param input user's inout
     * @return list of string
     */
    public List<String> searchGlobalByUserInput(String input) {
        return departmentRepository.globalSearchByInput(input);
    }
}
