/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jialei.myspringboot.demoelasticsearch.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 *
 * @author jialei
 * @version : Book.java, v 0.1 2020年01月26日 5:12 下午 jialei Exp $
 */
@Data
@Document(indexName = "book", type = "novel")
public class Book {
    private Integer id;
    private Integer word_count;
    private String  author;
    private String  title;
    private Date    date;
}