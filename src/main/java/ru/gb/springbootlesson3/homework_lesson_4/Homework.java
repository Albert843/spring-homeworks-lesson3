package ru.gb.springbootlesson3.homework_lesson_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.springbootlesson3.controllers.IssueRequest;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.services.BookService;
import ru.gb.springbootlesson3.services.IssueService;
import ru.gb.springbootlesson3.services.ReaderService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class Homework {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private IssueService issueService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/readers")
    public String getAllReaders(Model model) {
        List<Reader> readers = readerService.getAllReaders();
        model.addAttribute("readers", readers);
        return "readers";
    }

    @GetMapping("issues")
    public String getIssues(Model model) {
        List<Issue> list = new ArrayList<>();
        list.add(issueService.createIssue(new IssueRequest()));
        list.add(issueService.createIssue(new IssueRequest()));
        list.add(issueService.createIssue(new IssueRequest()));
        model.addAttribute("issues", list);
        return "issues";
    }

}
