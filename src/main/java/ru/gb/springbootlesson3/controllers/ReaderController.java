package ru.gb.springbootlesson3.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.services.ReaderService;
import ru.gb.springbootlesson3.entity.Reader;

import java.util.List;

@RestController
@RequestMapping("readers")
@RequiredArgsConstructor
@Slf4j
public class ReaderController {
    @Autowired
    private ReaderService service;

    @GetMapping
    public ResponseEntity<List<Reader>> getAllReaders() {
        return new ResponseEntity<>(service.getAllReaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reader> addReader(@RequestBody Reader reader) {
        return new ResponseEntity<>(service.addReader(reader), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reader> getById(@PathVariable("id") long id) {
        Reader reader = service.getById(id);
        if (reader != null) {
            return new ResponseEntity<>(reader, HttpStatus.OK );
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        service.deleteReader(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
