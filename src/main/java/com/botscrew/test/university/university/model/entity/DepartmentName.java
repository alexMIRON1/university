package com.botscrew.test.university.university.model.entity;

/**
 * enum for department's name
 *
 * @author Oleksandr Myronenko
 */
public enum DepartmentName {
    HUMAN_RESOURCES("Human Resources"),
    RESEARCH_AND_DEVELOPMENT("Research and Development"),
    SUPPORT("Support"),
    ENGINEERING("Engineering"),
    TRAINING("Training"),
    BUSINESS_DEVELOPMENT("Business Development"),
    LEGAL("Legal");
    private final String value;

    DepartmentName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
