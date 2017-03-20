package com.jialei.MixConfig.javaBean;

import com.jialei.MixConfig.CDPlayerMixConfig;
import com.jialei.MixConfig.CompactDiscMixConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by cdjialei on 2017/3/20.
 */
@Configuration
@ImportResource("classpath:cd_config.xml")
public class MixJavaWithXMLConfiguration {
    private final Logger logger = LoggerFactory.getLogger(CDPlayerConfigMixConfig.class);

    @Bean
    public CDPlayerMixConfig cdPlayerMixConfig(CompactDiscMixConfig compactDiscMixConfig) {
        logger.info("Get players");
        return new CDPlayerMixConfig(compactDiscMixConfig);
    }
}
