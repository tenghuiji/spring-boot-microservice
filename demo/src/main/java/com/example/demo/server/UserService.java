package com.example.demo.server;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    static Map<Integer, User> userMap = Collections.synchronizedMap(new HashMap<>());

    public static Map<Integer, User> getUserMap() {
        return userMap;
    }

    public String putUser(User user){
        this.putUser(user.getId(), user);
        return "Success";
    }

    public String putUser(int id, User user){
        userMap.put(id, user);
        return "Success";
    }

    public List<User> getUserList(){
        return new ArrayList<>(userMap.values());
    }

    public User selectUserById(int id) {
        User user = userMap.get(id);
        if(user != null)
        {
            return user;
        }else{
            return new User();
        }
    }

    public String removeById(int id){
        userMap.remove(id);
        return "Success";
    }
}
