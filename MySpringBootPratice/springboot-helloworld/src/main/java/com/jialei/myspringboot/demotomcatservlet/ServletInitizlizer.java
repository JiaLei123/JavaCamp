package com.jialei.myspringboot.demotomcatservlet;

import com.jialei.myspringboot.MyspringbootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitizlizer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyspringbootApplication.class);
    }
}
