package com.jialei.myspringboot.config;

import com.jialei.myspringboot.component.LoginHandlerInterceptor;
import com.jialei.myspringboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.LocaleResolver;

//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/jialei").setViewName("sucess");
        registry.addViewController("/main").setViewName("list");
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }



    @Bean
    public LocaleResolver localeResolver(){
    	return new MyLocaleResolver();
    }
}