package jialei.com.spitter.rmiclient;

import jialei.com.spitter.service.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiServiceClient {
    @Bean
    public RmiProxyFactoryBean spittleService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost:8866/SpittleService");
        rmiProxy.setServiceInterface(SpittleService.class);
        return rmiProxy;
    }
}