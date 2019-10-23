package com.jialei.myspringboot.controller;

import com.jialei.myspringboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 *
 * @author jialei
 * @version : LoginController.java, v 0.1 2019年10月16日 10:01 jialei Exp $
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        if(username.equals("123456")){
            throw new UserNotExistException("123456 not found");
        }

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username", username);
            return "redirect:/main";
        }


        model.addAttribute("msg", "用户密码错误");
        return "login";
    }

}