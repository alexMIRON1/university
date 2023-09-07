package com.botscrew.test.university.university.view;

import com.botscrew.test.university.university.view.factory.CommandFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * university runner for working with user input
 *
 * @author Oleksandr Myronenko
 */
@Component
@RequiredArgsConstructor
public class UniversityRunner implements CommandLineRunner {
    private final CommandFactory commandFactory;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            commandFactory.execute(input);
        }
    }
}
