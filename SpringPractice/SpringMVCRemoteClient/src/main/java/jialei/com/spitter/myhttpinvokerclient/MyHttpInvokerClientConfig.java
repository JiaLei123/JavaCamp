package jialei.com.spitter.myhttpinvokerclient;

import jialei.com.spitter.service.HttpInvokerSpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class MyHttpInvokerClientConfig {
    @Bean
    public HttpInvokerProxyFactoryBean httpInvokerSpittleService(){
        HttpInvokerProxyFactoryBean proxyFactoryBean = new HttpInvokerProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/spitter.service");
        proxyFactoryBean.setServiceInterface(HttpInvokerSpittleService.class);
        return proxyFactoryBean;
    }
}
