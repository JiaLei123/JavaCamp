/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package jialei.com.spitter.demoelasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(EsConfig.class);

    @Bean
    public TransportClient client() throws UnknownHostException {
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("localhost"), 9200);
        Settings settings = Settings.builder().put("cluster.name", "docker-cluster").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(transportAddress);
        logger.info("use es and elastic search connect successful");
        return client;
    }
}