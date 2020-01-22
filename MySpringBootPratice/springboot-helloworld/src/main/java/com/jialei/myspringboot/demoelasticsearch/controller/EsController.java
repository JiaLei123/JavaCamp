/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jialei.myspringboot.demoelasticsearch.controller;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jialei
 * @version : EsController.java, v 0.1 2020年01月22日 2:29 下午 jialei Exp $
 */
@RestController
@RequestMapping("es")
public class EsController {
    @Autowired
    private TransportClient client;

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("id") String id){
        GetResponse response =  this.client.prepareGet("book", "novel", id).get();
        return JSON.toJSONString(response);
    }
}