package jialei.com.spitter.remotedemo.rmi;

import jialei.com.spitter.service.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;


@Configuration
public class ExportRmiService {
    @Bean
    public RmiServiceExporter rmiExporter(SpittleService spittleService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spittleService);
        rmiServiceExporter.setServiceName("SpittleService");
        rmiServiceExporter.setServiceInterface(SpittleService.class);
        rmiServiceExporter.setRegistryPort(8866);
        return rmiServiceExporter;
    }
}
