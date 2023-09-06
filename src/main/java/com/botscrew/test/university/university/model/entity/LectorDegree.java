package com.botscrew.test.university.university.model.entity;

/**
 * enum for lector's degree
 *
 * @author Oleksandr Myronenko
 */
public enum LectorDegree {
    ASSISTANT("Assistant"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    PROFESSOR("Professor");
    private final String value;

    LectorDegree(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
