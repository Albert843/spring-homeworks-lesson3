package ru.gb.springbootlesson3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springbootlesson3.services.BookService;
import ru.gb.springbootlesson3.services.PersonService;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("any")
    public String any() {
        return "any";
    }

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("user")
    public String user() {
        return "user";
    }

    @GetMapping("auth")
    public String auth() {
        return "auth";
    }
}
