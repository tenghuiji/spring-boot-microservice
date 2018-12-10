package com.microservice.elasticsearch.service;

import com.microservice.elasticsearch.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Book findOne(Long id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    Page<Book> findByTitle(String title, PageRequest pageRequest);
}
