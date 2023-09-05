package com.botscrew.test.university.university.view;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * university runner for working with user input
 *
 * @author Oleksandr Myronenko
 */
@Component
public class UniversityRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains(PartCommands.WHO.name())) {
            //TODO: get head of department by department name
        } else if (input.contains(PartCommands.STATISTICS.name())) {
            //TODO: get statistics, count assistants, count professors, count associate professors by department
        } else if (input.contains(PartCommands.SALARY.name())) {
            //TODO: get average salary by department
        } else if (input.contains(PartCommands.EMPLOYEE.name())) {
            // TODO: get employee count by department
        } else if (input.contains(PartCommands.GLOBAL.name())) {
            // TODO: get all information that contains user's input word
        } else {
            System.out.println("We do not support such command, try again:");
        }
    }
}
