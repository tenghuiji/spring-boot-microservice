package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.server.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SwaggerDemoControllerTest {

    private UserService userService;
    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test
    public void getStudent() {
        User user = userService.selectUserById(10);

        assertThat(10,is(user.getId()));
        assertThat("王大锤",is(user.getName()));
        assertThat(23,is(user.getAge()));
    }
}