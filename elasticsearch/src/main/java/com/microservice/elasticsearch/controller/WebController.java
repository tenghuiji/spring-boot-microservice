package com.microservice.elasticsearch.controller;

import com.microservice.elasticsearch.entity.Book;
import com.microservice.elasticsearch.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {
    private static Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping("/tt")
    public String index1(
            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
            Model model){
        logger.info("come in tt");
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<Book> bookPage = bookService.findAll(pageable);
        model.addAttribute("book",bookPage);
        return "/index";
    }

    @RequestMapping("/search")
    public String search(String title, @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                         @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,Model model){
        logger.info("come in search");
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<Book> bookPage = bookService.findByTitle(title,pageable);
        List<Book> bookList = bookPage.getContent();
        model.addAttribute("book",bookList);
        return "/list";
    }
}
