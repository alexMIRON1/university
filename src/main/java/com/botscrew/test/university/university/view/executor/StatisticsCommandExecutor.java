package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.entity.LectorDegree;
import com.botscrew.test.university.university.service.LectorService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * class for executing command for word 'statistics'
 *
 * @author Oleksandr Myronenko
 */
@RequiredArgsConstructor
public class StatisticsCommandExecutor implements CommandExecutor {
    private final LectorService lectorService;

    @Override
    public void executeCommandByInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<LectorDegree, Long> result = lectorService.showStatisticsByDepartmentName(DepartmentName
                .valueOf(input.replace(" ", "_").toUpperCase()));
        for (Map.Entry<LectorDegree, Long> entry : result.entrySet()) {
            stringBuilder.append(entry.getKey().getValue())
                    .append(" - ")
                    .append(entry.getValue())
                    .append(".\n");
        }
        System.out.println(stringBuilder);
    }
}
