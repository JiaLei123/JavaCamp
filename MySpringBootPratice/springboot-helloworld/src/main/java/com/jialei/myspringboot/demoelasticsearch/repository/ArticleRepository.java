/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jialei.myspringboot.demoelasticsearch.repository;

import com.alibaba.fastjson.JSON;
import com.jialei.myspringboot.demoelasticsearch.model.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 *
 * @author jialei
 * @version : ArticleRepository.java, v 0.1 2020年01月26日 5:53 下午 jialei Exp $
 */
@Repository
public class ArticleRepository {

    private Logger     logger = LoggerFactory.getLogger(ArticleRepository.class);

    @Autowired
    private JestClient jestClient;

    public Integer saveToDB(@NotNull Article article, String index, String type){
        Index newIndex = new Index.Builder(article).index(index).type(type).build();
        try {
            jestClient.execute(newIndex);
        } catch (IOException e) {
            logger.error(JSON.toJSONString(e));
            return -1;
        }
        return article.getId();
    }

    public boolean deleteFromDB(@NotNull Article article, String index, String type){
        try {
            jestClient.execute(new Delete.Builder("1")
                    .index(index)
                    .type("tweet")
                    .build());
        } catch (IOException e) {
            logger.error(JSON.toJSONString(e));
            return false;
        }

        return true;
    }


}