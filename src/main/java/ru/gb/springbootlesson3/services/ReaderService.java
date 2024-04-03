package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderService {

    private final ReaderRepository readerRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDataBase() {
        readerRepository.save(new Reader("Костя"));
        readerRepository.save(new Reader("Василий"));
        readerRepository.save(new Reader("Семен"));
    }

    public List<Reader> getAllReaders() {
        Iterable<Reader> iterable = readerRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public Reader addReader(Reader reader) {
        log.info("Добавлен читатель: " + reader.getName());
        return readerRepository.save(reader);
    }

    public Reader getById(long id) {
        log.info("Получен читатель по id: " + id);
        return readerRepository.findById(id).get();
    }

    public void deleteReader(long id) {
        log.info("Удален читатель по id: " + id);
        readerRepository.deleteById(id);
    }
}
