package com.jialei.MixConfig.javaBean;

import com.jialei.MixConfig.CompactDiscMixConfig;
import com.jialei.MixConfig.sgtPeppersMixConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JiaLei on 2017/3/18.
 */
@Configuration
public class CDConfigMixConfig {
    private final Logger logger = LoggerFactory.getLogger(CDConfigMixConfig.class);

    @Bean
    public CompactDiscMixConfig sgtSeppersMixConfig(){
        logger.info("Get Mix CD");
        return new sgtPeppersMixConfig();
    }
}
