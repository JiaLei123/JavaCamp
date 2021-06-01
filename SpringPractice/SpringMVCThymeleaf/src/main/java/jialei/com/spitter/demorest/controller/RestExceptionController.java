package jialei.com.spitter.demorest.controller;

import jialei.com.spitter.model.DuplicateSpittleException;
import jialei.com.spitter.model.SpittleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionController {
    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNotFound(SpittleNotFoundException e){
        String message = e.getMessage();
        return new Error("Spittle not found");
    }
}
