package com.jialei.myspringboot.exception;

/**
 *
 * @author jialei
 * @version : UserNotExistException.java, v 0.1 2019年10月23日 10:57 jialei Exp $
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String message){
        super(message);
    }
}