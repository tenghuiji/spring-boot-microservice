package com.microservice.elasticsearch;

import com.microservice.elasticsearch.entity.Book;
import com.microservice.elasticsearch.service.BookService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private BookService bookService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

        Book b1=bookService.save(new Book("1001", "这是一个Spring Boot1.0的书籍", "Rambabu Posa", "23-FEB-2017"));
        Book b2=bookService.save(new Book("1002", "Apache的一本书籍", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Solr是一个搜索引擎", "Rambabu Posa", "21-MAR-2017"));

        //fuzzey search
//        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

        Page<Book> books = bookService.findByTitle("书", new PageRequest(0, 10));

        books.forEach(x -> System.out.println(x));

    }

    //useful for debug
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("<--ElasticSearch--");
    }

}