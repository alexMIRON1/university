package com.botscrew.test.university.university.model.service;

import com.botscrew.test.university.university.model.entity.Department;
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
    public String getDepartmentHeadNameByDepartmentName(String departmentName) {
        return departmentRepository.findHeadOfDepartmentByDepartmentName(departmentName);
    }

    /**
     * using to get count lectors by department name
     *
     * @param departmentName department name
     * @return count of lectors
     */
    public Integer getCountLectorsByDepartmentName(String departmentName) {
        return departmentRepository.getCountLectorsByDepartmentName(departmentName);
    }
    public List<String> getSomethingByUserInput(String input){
        return departmentRepository.globalSearchByInput(input);
    }
}
