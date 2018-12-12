package com.microservice.elasticsearch.controller;

import com.microservice.elasticsearch.entity.Book;
import com.microservice.elasticsearch.repository.BookRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.Optional;

import static org.junit.Assert.*;

public class WebControllerTest {
    private BookRepository bookRepository;

    @Test
    public void index1() {
        bookRepository = new BookRepository() {
            @Override
            public Page<Book> findByAuthor(String author, Pageable pageable) {
                return null;
            }

            @Override
            public Page<Book> findByTitle(String title, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Book> S index(S s) {
                return null;
            }

            @Override
            public Iterable<Book> search(QueryBuilder queryBuilder) {
                return null;
            }

            @Override
            public Page<Book> search(QueryBuilder queryBuilder, Pageable pageable) {
                return null;
            }

            @Override
            public Page<Book> search(SearchQuery searchQuery) {
                return null;
            }

            @Override
            public Page<Book> searchSimilar(Book book, String[] strings, Pageable pageable) {
                return null;
            }

            @Override
            public void refresh() {

            }

            @Override
            public Class<Book> getEntityClass() {
                return null;
            }

            @Override
            public Iterable<Book> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Book> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Book> S save(S s) {
                return null;
            }

            @Override
            public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Book> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Book> findAll() {
                return null;
            }

            @Override
            public Iterable<Book> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Book book) {

            }

            @Override
            public void deleteAll(Iterable<? extends Book> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
        bookRepository.findAll();
    }

    @Test
    public void search() {
    }
}