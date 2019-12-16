package com.jialei.myspringboot.demojpa.controller;

import com.jialei.myspringboot.model.User;
import com.jialei.myspringboot.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author jialei
 * @version : JpaController.java, v 0.1 2019年11月21日 10:36 上午 jialei Exp $
 */
@Controller
@RequestMapping("jpa")
public class JpaController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<User> queryAll(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
}