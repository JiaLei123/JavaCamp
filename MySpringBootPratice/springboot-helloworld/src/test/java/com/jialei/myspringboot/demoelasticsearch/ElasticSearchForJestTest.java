package com.jialei.myspringboot.demoelasticsearch;

import com.alibaba.fastjson.JSON;
import com.jialei.myspringboot.demoelasticsearch.model.Article;
import com.jialei.myspringboot.demoelasticsearch.repository.ArticleRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author jialei
 * @version : ElasticSearchForJestTest.java, v 0.1 2020年01月26日 5:18 下午 jialei Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchForJestTest {
    private Logger logger = LoggerFactory.getLogger(ElasticSearchForJestTest.class);

    @Autowired
    private JestClient jestClient;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void saveDateTest(){
        Article article = new Article();
        article.setId(111212);
        article.setAuthor("jialei");
        article.setTitle("TestCase");
        article.setContent("This is a test case");

        Integer id = articleRepository.saveToDB(article, "article", "news");
        Assert.assertEquals((int)id, 111212);
        boolean result = articleRepository.deleteFromDB(article, "article", "news");
        Assert.assertTrue(result);
    }


    @Test
    public void queryDateTest(){
        Article article = new Article();
        article.setId(111213);
        article.setAuthor("jialei");
        article.setTitle("TestCase");
        article.setContent("This is a test case");

        Integer id = articleRepository.saveToDB(article, "article", "news");
        Assert.assertEquals((int)id, 111213);

        String json = "{\n"
                + "\t\"query\": {\n"
                + "\t\t\"match\":{\n"
                + "\t\t\t\"author\": \"jialei\"\n"
                + "\t\t}\n"
                + "\t}\n"
                + "}";
        Search search = new Search.Builder(json).addIndex("article").addType("news").build();

        try {
            SearchResult result = jestClient.execute(search);

            List<SearchResult.Hit<Article, Void>> hits = result.getHits(Article.class);
            SearchResult.Hit<Article, Void> items = hits.get(0);
            Article queryarticle = items.source;
            Assert.assertEquals(queryarticle.getTitle(), "TestCase");
            logger.info(JSON.toJSONString(article));
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean result = articleRepository.deleteFromDB(article, "article", "news");
        Assert.assertTrue(result);
    }


    //@Test manual test
    public void saveDataTest(){
        Article article = new Article();
        article.setAuthor("lina");
        article.setTitle("GoodWork");
        article.setContent("This is a good book");

        Index index = new Index.Builder(article).index("article").type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Test manual test
    public void searchDataTest(){
        String json = "{\n"
                + "\t\"query\": {\n"
                + "\t\t\"match\":{\n"
                + "\t\t\t\"content\": \"this\"\n"
                + "\t\t}\n"
                + "\t}\n"
                + "}";
        Search search = new Search.Builder(json).addIndex("article").addType("news").build();

        try {
            SearchResult result = jestClient.execute(search);

            List<SearchResult.Hit<Article, Void>> hits = result.getHits(Article.class);
            Assert.assertTrue(hits.size() > 0);
            SearchResult.Hit<Article, Void> items = hits.get(0);
            Article article = items.source;
            logger.info(JSON.toJSONString(article));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}