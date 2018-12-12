package com.microservice.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "book", type = "books",shards = 1, replicas = 0, refreshInterval = "-1")
public class Book {
    @Id
    private long id;

    @Field
    private String title;

    @Field
    private String author;

    @Field
    private String releaseDate;

    @Field
    private String content;

    public Book() {
    }

    public Book(final long id,
                final String title,
                final String author,
                final String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public Book setId(final long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Book setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Book setContent(final String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", content='" + content +'\'' +
                '}';
    }
}
