package jialei.com.spitter.remotedemo.myhttpinvoker;

import jialei.com.spitter.service.HttpInvokerSpittleService;
import jialei.com.spitter.service.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class MyHttpInvokerConfig {
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(HttpInvokerSpittleService httpInvokerSpittleService){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(httpInvokerSpittleService);
        exporter.setServiceInterface(HttpInvokerSpittleService.class);
        return exporter;
    }

    @Bean
    public HandlerMapping httpInvokerMapping(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spittle.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }
}
