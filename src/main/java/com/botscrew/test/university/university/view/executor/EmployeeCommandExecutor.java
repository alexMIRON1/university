package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;

/**
 * class for executing command with word 'employee'
 *
 * @author Oleksandr Myronenko
 */
@RequiredArgsConstructor
public class EmployeeCommandExecutor implements CommandExecutor {
    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Integer result = departmentService.getCountLectorsByDepartmentName(DepartmentName
                .valueOf(input.replace(" ", "_").toUpperCase()));
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }
}
