package com.jialei.myspringboot.demomyservlet.config;

import com.jialei.myspringboot.demomyservlet.listener.MyListener;
import com.jialei.myspringboot.demomyservlet.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.jialei.myspringboot.demomyservlet.filter.MyFilter;

import java.util.Arrays;

/**
 *
 * @author jialei
 * @version : MyServletConfig.java, v 0.1 2019年12月16日 12:03 下午 jialei Exp $
 */
public class MyServletConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myservlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }
}