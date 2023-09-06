package com.botscrew.test.university.university.view;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.service.DepartmentService;
import com.botscrew.test.university.university.service.LectorService;
import com.botscrew.test.university.university.view.exception.WrongDepartmentName;
import com.botscrew.test.university.university.view.executor.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

/**
 * university runner for working with user input
 *
 * @author Oleksandr Myronenko
 */
@Component
@RequiredArgsConstructor
public class UniversityRunner implements CommandLineRunner {
    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private CommandExecutor commandExecutor;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.contains(PartCommands.WHO.getValue().toLowerCase())) {
                    commandExecutor = new WhoCommandExecutor(departmentService);
                    commandExecutor.executeCommandByInput(retrieveDepartmentName(input)
                            .orElseThrow(WrongDepartmentName::new).getValue());
                } else if (input.contains(PartCommands.STATISTICS.getValue().toLowerCase())) {
                    commandExecutor = new StatisticsCommandExecutor(lectorService);
                    commandExecutor.executeCommandByInput(retrieveDepartmentName(input)
                            .orElseThrow(WrongDepartmentName::new).getValue());
                } else if (input.contains(PartCommands.SALARY.getValue().toLowerCase())) {
                    commandExecutor = new SalaryCommandExecutor(lectorService);
                    commandExecutor.executeCommandByInput(retrieveDepartmentName(input)
                            .orElseThrow(WrongDepartmentName::new).getValue());
                } else if (input.contains(PartCommands.EMPLOYEE.getValue().toLowerCase())) {
                    commandExecutor = new EmployeeCommandExecutor(departmentService);
                    commandExecutor.executeCommandByInput(retrieveDepartmentName(input)
                            .orElseThrow(WrongDepartmentName::new).getValue());
                } else if (input.contains(PartCommands.GLOBAL.getValue().toLowerCase())) {
                    commandExecutor = new GlobalCommandExecutor(departmentService);
                    commandExecutor.executeCommandByInput(input);
                } else {
                    System.out.println("We do not support such command, try again:");
                }
            } catch (WrongDepartmentName e) {
                System.out.println("Such department does not exist");
            }
        }
    }

    private Optional<DepartmentName> retrieveDepartmentName(String input) {
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
