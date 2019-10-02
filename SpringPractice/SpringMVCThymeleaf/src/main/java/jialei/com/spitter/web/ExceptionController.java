package jialei.com.spitter.web;

import jialei.com.spitter.model.DuplicateSpittleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicteSpittle(){
        return "error/duplicate";
    }
}
