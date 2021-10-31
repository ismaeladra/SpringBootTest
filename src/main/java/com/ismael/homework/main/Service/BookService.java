package com.ismael.homework.main.Service;

import com.ismael.homework.main.Entity.Book;
import com.ismael.homework.main.Exception.ResourceNotFoundException;
import com.ismael.homework.main.Repository.AuthorRepository;
import com.ismael.homework.main.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findBooksByAuthor(Long authorId){
        return bookRepository.findAllByAuthorIdEquals(authorId);
    }

    public Book create(Long authorId, Book book) throws ResourceNotFoundException {
        return authorRepository.findById(authorId).map((author -> {
            book.setAuthor(author);
            return bookRepository.save(book);
        })).orElseThrow(()->  new ResourceNotFoundException("Author not Found"));
    }


    public Book update(Long Id, Book book) throws ResourceNotFoundException {

        return bookRepository.findById(Id).map((book1 -> {
            book1.setName(book.getName());
            return bookRepository.save(book1);
        })).orElseThrow(()->new ResourceNotFoundException("Book Not Found"));
    }
    public boolean delete(Long Id) throws ResourceNotFoundException {
        return bookRepository.findById(Id).map((book -> {
            bookRepository.delete(book);
            return true;
        })).orElseThrow(()->new ResourceNotFoundException("Author Not Found"));
    }
}
