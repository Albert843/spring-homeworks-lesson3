package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        log.info("Получен список книг: " + bookRepository.getAllBooks());
        return bookRepository.getAllBooks();
    }

    public Book addBook(Book book) {
        log.info("Добавлена книга: " + book.getName());
        return bookRepository.addBook(book);
    }

    public Book getById(long id) {
        log.info("Получена книга по id: " + id);
        return bookRepository.findById(id);
    }

    public void deleteBook(long id) {
        log.info("Удалена книга по id: " + id);
        bookRepository.deleteBook(id);
    }



}
