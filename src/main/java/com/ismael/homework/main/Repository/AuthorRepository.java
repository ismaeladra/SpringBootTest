package com.ismael.homework.main.Repository;

import com.ismael.homework.main.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
