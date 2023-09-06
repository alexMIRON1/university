package com.botscrew.test.university.university.view.executor;

/**
 * interface describes strategy for executing user's commands
 *
 * @author Oleksandr Myronenko
 */
public interface CommandExecutor {
    /**
     * using for executing command by department name
     *
     * @param input user input
     */
    void executeCommandByInput(String input);
}
