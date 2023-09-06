package com.botscrew.test.university.university.view.executor;

import com.botscrew.test.university.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.StringJoiner;

@RequiredArgsConstructor
public class GlobalCommandExecutor implements CommandExecutor {
    private final DepartmentService departmentService;

    @Override
    public void executeCommandByInput(String input) {
        String finderPhrase = "global search by ";
        List<String> results = departmentService.searchGlobalByUserInput(input.replace(finderPhrase, ""));
        StringJoiner stringJoiner = new StringJoiner(", ");
        results.forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }
}
