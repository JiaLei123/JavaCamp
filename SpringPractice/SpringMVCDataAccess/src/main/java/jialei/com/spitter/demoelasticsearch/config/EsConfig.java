/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package jialei.com.spitter.demoelasticsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author jialei
 * @version : EsConfig.java, v 0.1 2020年01月22日 12:16 下午 jialei Exp $
 */
@Configuration
public class EsConfig {
    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"), 9300
        );


        Settings settings = Settings.builder().put("cluster.name", "docker-cluster").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }
}