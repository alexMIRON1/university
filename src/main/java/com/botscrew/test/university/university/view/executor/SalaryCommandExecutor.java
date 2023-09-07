package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.DepartmentService;
import com.botscrew.test.university.university.service.LectorService;
import com.botscrew.test.university.university.view.TypeCommands;
import com.botscrew.test.university.university.view.exception.WrongDepartmentName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * class for executing command with word 'salary'
 *
 * @author Oleksandr Myronenko
 */
@Component(TypeCommands.SALARY)
@RequiredArgsConstructor
public class SalaryCommandExecutor implements CommandExecutor {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            DepartmentName departmentName = departmentService.retrieveDepartmentName(input)
                    .orElseThrow(WrongDepartmentName::new);
            Double result = lectorService.getAverageSalaryByDepartmentName(departmentName);
            stringBuilder.append("The average salary of ")
                    .append(departmentName.getValue())
                    .append(" is ")
                    .append(result);
            System.out.println(stringBuilder);
        } catch (WrongDepartmentName e) {
            System.out.println("Such department does not exist");
        }

    }
}
