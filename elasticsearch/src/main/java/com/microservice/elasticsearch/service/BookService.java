package com.microservice.elasticsearch.service;

import com.microservice.elasticsearch.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Book findOne(Long id);

    Page<Book> findAll(Pageable pageable);

    Page<Book> findByAuthor(String author, Pageable pageRequest);

    Page<Book> findByTitle(String title, Pageable pageRequest);
}
