package com.ismael.homework.main.Controller;

import com.ismael.homework.main.Entity.Book;
import com.ismael.homework.main.Exception.ResourceNotFoundException;
import com.ismael.homework.main.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{author_id}")
    public List<Book> getAuthorBooks(@PathVariable(name = "author_id") Long authorId){
        return bookService.findBooksByAuthor(authorId);
    }
    @PostMapping("/{author_id}")
    public Book create(@PathVariable(name = "author_id") Long authorId,@RequestBody Book book) throws ResourceNotFoundException {
        return bookService.create(authorId,book);
    }
    @PutMapping("/{book_id}")
    public Book update(@PathVariable(name = "book_id") Long Id,@RequestBody Book book) throws ResourceNotFoundException{
        return bookService.update(Id,book);
    }
    @DeleteMapping("/{book_id}")
    public boolean delete(@PathVariable(name = "book_id") Long Id) throws ResourceNotFoundException {
        return bookService.delete(Id);
    }

}
