package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.server.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2017/9/13.
 */
@RestController
@RequestMapping("user")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {
    private static final Logger logger= LoggerFactory.getLogger(SwaggerDemoController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表",notes="展示所有用户")
    @RequestMapping(value = {""},method = RequestMethod.GET)
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @ApiOperation(value="创建用户", notes="根据用户新消息创建用户")
    @ApiImplicitParam(name = "User", value = "用户详细信息", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        logger.info("创建用户id:"+user.getId());
        userService.putUser(user);
        return "success";
    }

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个的用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getStudent(@PathVariable int id) {
        logger.info("开始查询ID为"+id+"的用户信息");
        return userService.selectUserById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            //@ApiImplicitParam(name = "age", value = "用户age", required = true, dataType = "Integer"),
            //@ApiImplicitParam(name = "name", value = "用户name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User u = userService.getUserMap().get(id);
        if(u!=null) {
            u.setName(user.getName());
            u.setAge(user.getAge());
            userService.putUser(id,u);
            return "success";
        }
        return "failed";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        userService.removeById(id);
        return "success";
    }
}
