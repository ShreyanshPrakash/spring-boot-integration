package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorDataController {


    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public AuthorDto getAuthorById(@PathVariable String id){
        return authorService.getAuthorById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<AuthorDto> addAnAuthor(@RequestBody AuthorDto author){
        return authorService.addAnAuthor(author);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<AuthorDto> deleteAuthorById(@PathVariable String id){
        return authorService.deleteAuthorById(id);
    }

}
