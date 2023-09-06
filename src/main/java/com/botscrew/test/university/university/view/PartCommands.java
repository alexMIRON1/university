package com.botscrew.test.university.university.view;

/**
 * enum for part of input commands
 *
 * @author Oleksandr Myronenko
 */
public enum PartCommands {
    WHO("Who"),
    STATISTICS("Statistics"),
    SALARY("Salary"),
    EMPLOYEE("Employee"),
    GLOBAL("Global");
    private final String value;

    PartCommands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
