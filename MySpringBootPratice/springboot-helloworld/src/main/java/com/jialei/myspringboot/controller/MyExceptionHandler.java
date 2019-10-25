package com.jialei.myspringboot.controller;

import com.jialei.myspringboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : MyExceptionHandler.java, v 0.1 2019年10月23日 10:55 jialei Exp $
 */
@ControllerAdvice
public class MyExceptionHandler {
    //@ResponseBody
    //@ExceptionHandler(UserNotExistException.class)
    //public Map<String, Object> handlerException(Exception ex){
    //    Map<String, Object> map = new HashMap<>();
    //    map.put("code", "user.notexist");
    //    map.put("message", ex.getMessage());
    //    return map;
    //}


    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception ex, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", ex.getMessage());

        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("ext", map);

        return "forward:/error";
    }

}