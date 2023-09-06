package com.botscrew.test.university.university.view.exception;

public class WrongDepartmentName extends RuntimeException {
    public WrongDepartmentName() {
    }

    public WrongDepartmentName(String message) {
        super(message);
    }
}
