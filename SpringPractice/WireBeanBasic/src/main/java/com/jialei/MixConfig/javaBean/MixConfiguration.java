package com.jialei.MixConfig.javaBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by cdjialei on 2017/3/20.
 */
@Configuration
@Import({CDConfigMixConfig.class, CDPlayerConfigMixConfig.class})
public class MixConfiguration {
}
