package ru.gb.springbootlesson3.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.services.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(),HttpStatus.OK);
    }

   @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
   }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") long id) {
        Book book = service.getById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        service.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

