package com.ismael.homework.main.Service;

import com.ismael.homework.main.Entity.Author;
import com.ismael.homework.main.Entity.Book;
import com.ismael.homework.main.Exception.ResourceNotFoundException;
import com.ismael.homework.main.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
    public Author create(Author author){
        return authorRepository.save(author);
    }

    public Author update(Long Id, Author author) throws ResourceNotFoundException {
        return authorRepository.findById(Id).map((author1 -> {
            author1.setName(author.getName());
            return authorRepository.save(author1);
        })).orElseThrow(()->new ResourceNotFoundException("Author Not Found"));

    }
    public boolean delete(Long Id) throws ResourceNotFoundException {
        return authorRepository.findById(Id).map((author -> {
            authorRepository.delete(author);
            return true;
        })).orElseThrow(()->new ResourceNotFoundException("Author Not Found"));
    }
}
