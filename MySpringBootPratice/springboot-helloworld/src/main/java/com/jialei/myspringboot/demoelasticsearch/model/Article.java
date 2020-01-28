/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jialei.myspringboot.demoelasticsearch.model;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 *
 * @author jialei
 * @version : Article.java, v 0.1 2020年01月26日 5:13 下午 jialei Exp $
 */
@Data
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}