package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.LectorService;
import lombok.RequiredArgsConstructor;

/**
 * class for executing command with word 'salary'
 *
 * @author Oleksandr Myronenko
 */
@RequiredArgsConstructor
public class SalaryCommandExecutor implements CommandExecutor {
    private final LectorService lectorService;

    @Override
    public void executeCommandByInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        DepartmentName departmentName = DepartmentName.valueOf(input.replace(" ", "_").toUpperCase());
        Double result = lectorService.getAverageSalaryByDepartmentName(departmentName);
        stringBuilder.append("The average salary of ")
                .append(departmentName.getValue())
                .append(" is ")
                .append(result);
        System.out.println(stringBuilder);
    }
}
