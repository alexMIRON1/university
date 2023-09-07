package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.DepartmentService;
import com.botscrew.test.university.university.view.TypeCommands;
import com.botscrew.test.university.university.view.exception.WrongDepartmentName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * class for executing command with word 'employee'
 *
 * @author Oleksandr Myronenko
 */
@Component(TypeCommands.EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeCommandExecutor implements CommandExecutor {
    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            DepartmentName departmentName = departmentService.retrieveDepartmentName(input)
                    .orElseThrow(WrongDepartmentName::new);
            Integer result = departmentService.getCountLectorsByDepartmentName(departmentName);
            stringBuilder.append(result);
            System.out.println(stringBuilder);
        } catch (WrongDepartmentName e) {
            System.out.println("Such department does not exist");
        }
    }
}
