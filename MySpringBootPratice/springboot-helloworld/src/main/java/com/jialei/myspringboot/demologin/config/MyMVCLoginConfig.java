package com.jialei.myspringboot.demologin.config;

import com.jialei.myspringboot.demologin.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author jialei
 * @version : loginConfig.java, v 0.1 2019年12月16日 11:50 上午 jialei Exp $
 */
@Configuration
public class MyMVCLoginConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/user/login");
    }

}