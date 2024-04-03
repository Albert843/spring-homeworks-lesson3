package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.repository.BookRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDataBase() {
        bookRepository.save(new Book("Война и мир"));
        bookRepository.save(new Book("Мастер и Маргарита"));
        bookRepository.save(new Book("Приключения Буратино"));
    }

    public List<Book> getAllBooks() {
        Iterable<Book> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public Book addBook(Book book) {
        log.info("Добавлена книга: " + book.getName());
        return bookRepository.save(book);
    }

    public Book getById(long id) {
        log.info("Получена книга по id: " + id);
        return bookRepository.findById(id).get();
    }

    public void deleteBook(long id) {
        log.info("Удалена книга по id: " + id);
        bookRepository.deleteById(id);
    }
}
