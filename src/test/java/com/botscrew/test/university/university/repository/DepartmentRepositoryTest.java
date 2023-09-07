package com.botscrew.test.university.university.repository;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * tests for {@link DepartmentRepository}
 *
 * @author Oleksandr Myronenko
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void findHeadOfDepartmentByDepartmentNameTest() {
        String actualHeadOfDepartment = departmentRepository.findHeadOfDepartmentByDepartmentName(DepartmentName.TRAINING);
        String expectedHeadOfDepartment = "Edwin Issett";
        assertEquals(expectedHeadOfDepartment, actualHeadOfDepartment);
    }

    @Test
    void getCountLectorsByDepartmentNameTest() {
        Integer actualCountLectors = departmentRepository.getCountLectorsByDepartmentName(DepartmentName.LEGAL);
        Integer expectedCountLectors = 2;
        assertEquals(expectedCountLectors, actualCountLectors);
    }

    @Test
    void globalSearchByInputTest() {
        List<String> actualStrings = departmentRepository.globalSearchByInput("an");
        List<String> expectedStrings = List.of("Anette Seaton", "Sybilla Pillman", "ASSISTANT",
                "RESEARCH_AND_DEVELOPMENT", "Antonin Dibble", "Ike Mancell", "Coleman Apedaile", "HUMAN_RESOURCES");
        IntStream.range(0, expectedStrings.size())
                .forEach(i -> assertEquals(expectedStrings.get(i), actualStrings.get(i)));
    }
}
