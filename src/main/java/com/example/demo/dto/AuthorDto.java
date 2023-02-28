package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private String id;
    private String name;
    private int age;
    private String occupation;
}
