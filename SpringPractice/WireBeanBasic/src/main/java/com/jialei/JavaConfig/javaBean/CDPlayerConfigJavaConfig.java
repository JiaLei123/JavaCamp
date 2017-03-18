package com.jialei.JavaConfig.javaBean;

import com.jialei.JavaConfig.CDPlayerJavaConfig;
import com.jialei.JavaConfig.CompactDiscJavaConfig;
import com.jialei.JavaConfig.sgtPeppersJavaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JiaLei on 2017/3/18.
 */
@Configuration
public class CDPlayerConfigJavaConfig {
    private final Logger logger = LoggerFactory.getLogger(CDPlayerConfigJavaConfig.class);

    @Bean
    public CompactDiscJavaConfig sgtSeppersJavaConfig(){
        logger.info("Get CD");
        return new sgtPeppersJavaConfig();
    }

    @Bean
    public CDPlayerJavaConfig cdPlayerJavaConfig(CompactDiscJavaConfig compactDiscJavaConfig){
        logger.info("Get players");
        return  new CDPlayerJavaConfig(compactDiscJavaConfig);
    }
}
