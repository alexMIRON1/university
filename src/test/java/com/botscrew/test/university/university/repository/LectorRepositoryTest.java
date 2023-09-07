package com.botscrew.test.university.university.repository;

import com.botscrew.test.university.university.model.entity.DepartmentName;
import com.botscrew.test.university.university.model.entity.LectorDegree;
import com.botscrew.test.university.university.model.repository.LectorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * tests for {@link LectorRepository}
 *
 * @author Oleksandr Myronenko
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LectorRepositoryTest {
    @Autowired
    private LectorRepository lectorRepository;

    @Test
    void findLectorDegreeCountByDepartmentNameTest() {
        List<Object[]> actualList = lectorRepository.findLectorDegreeCountByDepartmentName(DepartmentName.TRAINING);
        List<Object[]> expectedList = List.of(
                new Object[]{LectorDegree.ASSOCIATE_PROFESSOR, 1L},
                new Object[]{LectorDegree.PROFESSOR, 2L},
                new Object[]{LectorDegree.ASSISTANT, 1L}
        );
        IntStream.range(0, expectedList.size())
                .forEach(i -> assertArrayEquals(expectedList.get(i), actualList.get(i)));
    }

    @Test
    void getAverageSalaryByDepartmentTest() {
        Double actualSalary = lectorRepository.getAverageSalaryByDepartment(DepartmentName.ENGINEERING);
        Double expectedSalary = 2621.55;
        assertEquals(expectedSalary, actualSalary);
    }
}
