package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;

/**
 * class for executing command with word 'who'
 *
 * @author Oleksandr Myronenko
 */
@RequiredArgsConstructor
public class WhoCommandExecutor implements CommandExecutor {

    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        DepartmentName departmentName = DepartmentName.valueOf(input.replace(" ", "_").toUpperCase());
        String result = departmentService.getDepartmentHeadNameByDepartmentName(departmentName);
        stringBuilder.append("Head of ")
                .append(departmentName.getValue())
                .append(" department is ")
                .append(result);
        System.out.println(stringBuilder);
    }
}
