package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.entity.LectorDegree;
import com.botscrew.test.university.university.service.DepartmentService;
import com.botscrew.test.university.university.service.LectorService;
import com.botscrew.test.university.university.view.TypeCommands;
import com.botscrew.test.university.university.view.exception.WrongDepartmentName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * class for executing command for word 'statistics'
 *
 * @author Oleksandr Myronenko
 */
@Component(TypeCommands.STATISTICS)
@RequiredArgsConstructor
public class StatisticsCommandExecutor implements CommandExecutor {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            DepartmentName departmentName = departmentService.retrieveDepartmentName(input)
                    .orElseThrow(WrongDepartmentName::new);
            Map<LectorDegree, Long> result = lectorService.showStatisticsByDepartmentName(departmentName);
            for (Map.Entry<LectorDegree, Long> entry : result.entrySet()) {
                stringBuilder.append(entry.getKey().getValue())
                        .append(" - ")
                        .append(entry.getValue())
                        .append(".\n");
            }
            System.out.println(stringBuilder);
        } catch (WrongDepartmentName e) {
            System.out.println("Such department does not exist");
        }

    }
}
