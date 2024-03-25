package ru.gb.springbootlesson3.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> list = new ArrayList<>();

    public BookRepository() {
        list.add(new Book("Война и мир"));
        list.add(new Book("Мастер и Маргарита"));
        list.add(new Book("Приключения Буратино"));
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book findById(long id) {
        return list.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    public void deleteBook(long id) {
        list.removeIf(book -> book.getId() == id);
    }
}
