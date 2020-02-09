package jialei.com.spitter.demosecurity.server;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class SecurityServer {

    @Secured("USER")
    public String getMessage(){
        return "security test";
    }
}
