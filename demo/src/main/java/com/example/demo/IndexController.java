package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/")
    public String index() {
        logger.info("come in hello");
        return "hello, there";
    }
}