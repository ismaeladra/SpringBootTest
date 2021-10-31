package com.ismael.homework.main.Repository;

import com.ismael.homework.main.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByAuthorIdEquals(Long authorId);
}
