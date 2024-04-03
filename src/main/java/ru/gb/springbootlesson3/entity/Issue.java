package ru.gb.springbootlesson3.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "issues")
@NoArgsConstructor
//@Component
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "idReader")
    private long idReader;

    @Column(name = "idBook")
    private long idBook;

    @Column(name = "time")
    private LocalDateTime time;

    public Issue(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        time = LocalDateTime.now();
    }
}
