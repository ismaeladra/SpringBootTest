package com.ismael.homework.main.Controller;


import com.ismael.homework.main.Entity.Author;
import com.ismael.homework.main.Entity.Response;
import com.ismael.homework.main.Exception.ResourceNotFoundException;
import com.ismael.homework.main.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @GetMapping("/")
    public List<Author> index(){
        return authorService.findAll();
    }
    @PostMapping("/")
    public Author create(@RequestBody  Author author){
        return authorService.create(author);
    }
    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable Long id) throws ResourceNotFoundException {
         return authorService.update(id,author);

    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) throws ResourceNotFoundException {
        return authorService.delete(id);
    }


}
