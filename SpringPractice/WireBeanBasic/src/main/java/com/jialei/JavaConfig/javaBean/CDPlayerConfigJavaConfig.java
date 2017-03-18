package com.jialei.JavaConfig.javaBean;

import com.jialei.JavaConfig.CDPlayerJavaConfig;
import com.jialei.JavaConfig.CompactDiscJavaConfig;
import com.jialei.JavaConfig.sgtPeppersJavaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JiaLei on 2017/3/18.
 */
@Configuration
public class CDPlayerConfigJavaConfig {
    @Bean
    public CompactDiscJavaConfig sgtSeppersJavaConfig(){
        System.out.println("Get CD");
        return new sgtPeppersJavaConfig();
    }

    @Bean
    public CDPlayerJavaConfig cdPlayerJavaConfig(CompactDiscJavaConfig compactDiscJavaConfig){
        System.out.println("Get players");
        return  new CDPlayerJavaConfig(compactDiscJavaConfig);
    }
}
