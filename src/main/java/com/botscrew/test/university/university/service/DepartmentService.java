package com.botscrew.test.university.university.service;

import com.botscrew.test.university.university.model.entity.Department;
import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * using for retrieving department name by user input
     *
     * @param input user input
     * @return optional department name
     */
    public Optional<DepartmentName> retrieveDepartmentName(String input) {
        if (input.contains(DepartmentName.HUMAN_RESOURCES.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.HUMAN_RESOURCES);
        } else if (input.contains(DepartmentName.BUSINESS_DEVELOPMENT.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.BUSINESS_DEVELOPMENT);
        } else if (input.contains(DepartmentName.ENGINEERING.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.ENGINEERING);
        } else if (input.contains(DepartmentName.RESEARCH_AND_DEVELOPMENT.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.RESEARCH_AND_DEVELOPMENT);
        } else if (input.contains(DepartmentName.LEGAL.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.LEGAL);
        } else if (input.contains(DepartmentName.SUPPORT.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.SUPPORT);
        } else if (input.contains(DepartmentName.TRAINING.getValue().toLowerCase())) {
            return Optional.of(DepartmentName.TRAINING);
        }
        return Optional.empty();
    }
}
