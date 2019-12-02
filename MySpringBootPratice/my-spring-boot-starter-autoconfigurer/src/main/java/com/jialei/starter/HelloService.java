/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.starter;

/**
 *
 * @author jialei
 * @version : HelloService.java, v 0.1 2019年12月02日 10:30 上午 jialei Exp $
 */
public class HelloService {
    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String runService(){
        return helloProperties.getPrefix() + "-Hello-" + helloProperties.getSuffix();
    }
}