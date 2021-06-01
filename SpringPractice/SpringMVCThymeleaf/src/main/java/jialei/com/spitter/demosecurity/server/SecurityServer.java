package jialei.com.spitter.demosecurity.server;

import jialei.com.spitter.model.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityServer {

    @Secured("ROLE_USER")
    public String getMessage(){
        return "security test";
    }

    @PreAuthorize("(hasRole('ROLE_USER')) and #spittle.message.length() <= 140")
    public String getMessage1(Spittle spittle){
        return "security test";
    }

    @PostAuthorize("returnObject.length() > 100")
    public String getMessage2(Spittle spittle){
        return "security test";
    }

    @PostFilter("hasRole('ROLE_ADMIN') || filterObject.spitter.username == principal.username")
    public List<Spittle> getMessage3(){
        return new ArrayList<Spittle>();
    }

}
