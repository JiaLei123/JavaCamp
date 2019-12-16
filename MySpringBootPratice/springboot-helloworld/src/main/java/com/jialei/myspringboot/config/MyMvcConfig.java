package com.jialei.myspringboot.config;

import com.jialei.myspringboot.component.MyLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.LocaleResolver;

//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/jialei").setViewName("sucess");
        registry.addViewController("/main").setViewName("dashboard");
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }

    @Bean
    public LocaleResolver localeResolver(){
    	return new MyLocaleResolver();
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }

}