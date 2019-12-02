package com.jialei.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author jialei
 * @version : com.jialei.starter.HelloProperties.java, v 0.1 2019年12月02日 10:27 上午 jialei Exp $
 */
@ConfigurationProperties(prefix = "jialei.hello")
public class HelloProperties {
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String prefix;
    private String suffix;
}