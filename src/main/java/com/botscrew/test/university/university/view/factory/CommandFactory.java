package com.botscrew.test.university.university.view.factory;

import com.botscrew.test.university.university.view.TypeCommands;
import com.botscrew.test.university.university.view.exception.WrongTypeCommands;
import com.botscrew.test.university.university.view.executor.CommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * responsible for making command and trigger to execute them
 *
 * @author Oleksandr Myronenko
 */
@Component
@RequiredArgsConstructor
public class CommandFactory {
    private final Map<String, CommandExecutor> commandExecutorMap;

    /**
     * using for executing commands by user input
     *
     * @param input user input
     */
    public void execute(String input) {
        try {
            String typeCommands = getTypeCommands(input);
            CommandExecutor commandExecutor = getCommandExecutor(typeCommands);
            commandExecutor.executeCommandByInput(input);
        } catch (WrongTypeCommands e) {
            System.out.println("Such command does not exist");
        }
    }

    private String getTypeCommands(String input) {
        if (input.contains(TypeCommands.WHO)) {
            return TypeCommands.WHO;
        } else if (input.contains(TypeCommands.EMPLOYEE)) {
            return TypeCommands.EMPLOYEE;
        } else if (input.contains(TypeCommands.SALARY)) {
            return TypeCommands.SALARY;
        } else if (input.contains(TypeCommands.GLOBAL)) {
            return TypeCommands.GLOBAL;
        } else if (input.contains(TypeCommands.STATISTICS)) {
            return TypeCommands.STATISTICS;
        } else {
            throw new WrongTypeCommands();
        }
    }

    private CommandExecutor getCommandExecutor(String typeCommands) {
        return commandExecutorMap.get(typeCommands);
    }

}
