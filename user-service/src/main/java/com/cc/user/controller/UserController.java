package com.cc.user.controller;

import com.cc.user.entity.User;
import com.cc.user.service.UserService;
import com.cc.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MajdHaidar
 * @date 4/19/22
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO returnUserDepartmentById(@PathVariable("id") Long id){
        log.info("inside returnUserDepartmentById of UserController");
        return userService.returnUserDepartmentById(id);
    }
}
