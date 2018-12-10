package com.microservice.elasticsearch.repository;

import com.microservice.elasticsearch.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface BookRepository extends ElasticsearchRepository<Book, Long> {
    Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);
}
