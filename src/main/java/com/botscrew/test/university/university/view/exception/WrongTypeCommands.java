package com.botscrew.test.university.university.view.exception;

public class WrongTypeCommands extends RuntimeException {
    public WrongTypeCommands() {
    }

    public WrongTypeCommands(String message) {
        super(message);
    }
}
