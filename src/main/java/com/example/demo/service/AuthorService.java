package com.example.demo.service;

import com.example.demo.dto.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private List<AuthorDto> authors = new ArrayList<AuthorDto>();

    public List<AuthorDto> getAllAuthors(){
        return authors;
    }

    public List<AuthorDto> addAnAuthor(AuthorDto author){
        authors.add(author);
        return authors;
    }

    public AuthorDto getAuthorById(String id){
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    public List<AuthorDto> deleteAuthorById(String id){
         authors = authors.stream().filter(author -> !author.getId().equals(id)).toList();
         return authors;
    }

}
