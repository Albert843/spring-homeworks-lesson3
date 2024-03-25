package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderService {
    @Autowired
    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        log.info("Получен список читателей: " + readerRepository.getAllReaders());
        return readerRepository.getAllReaders();
    }

    public Reader addReader(Reader reader) {
        log.info("Добавлен читатель: " + reader.getName());
        return readerRepository.addReader(reader);
    }

    public Reader getById(long id) {
        log.info("Получен читатель по id: " + id);
        return readerRepository.findById(id);
    }

    public void deleteReader(long id) {
        log.info("Удален читатель по id: " + id);
        readerRepository.deleteReader(id);
    }
}
