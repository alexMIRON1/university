package com.botscrew.test.university.university.model.repository;

import com.botscrew.test.university.university.model.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * allow us working with lector table {@link Lector}
 *
 * @author Oleksandr Myronenko
 */
public interface LectorRepository extends JpaRepository<Lector, Long> {
}
