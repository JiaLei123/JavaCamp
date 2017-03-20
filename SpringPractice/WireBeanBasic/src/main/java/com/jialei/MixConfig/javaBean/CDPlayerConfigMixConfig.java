package com.jialei.MixConfig.javaBean;

import com.jialei.MixConfig.CDPlayerMixConfig;
import com.jialei.MixConfig.CompactDiscMixConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by JiaLei on 2017/3/18.
 */
@Configuration
@Import(CDConfigMixConfig.class)
public class CDPlayerConfigMixConfig {
    private final Logger logger = LoggerFactory.getLogger(CDPlayerConfigMixConfig.class);

    @Bean
    public CDPlayerMixConfig cdPlayerMixConfig(CompactDiscMixConfig compactDiscMixConfig){
        logger.info("Get players");
        return  new CDPlayerMixConfig(compactDiscMixConfig);
    }
}
