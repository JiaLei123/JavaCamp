/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package jialei.com.spitter.demoelasticsearch.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", "abc")
                    .field("author", "lina")
                    .field("word_count", 3000)
                    .field("date", "2018-11-22")
                    .endObject();
            IndexResponse response = this.client.prepareIndex("book", "novel")
                    .setSource(content)
                    .get();
            return JSON.toJSONString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("delete/{id}")
    public String Delete(@PathVariable("id") String id){
        DeleteResponse response = this.client.prepareDelete("book", "novel", id).get();
        return JSON.toJSONString(response);
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        UpdateRequest updateRequest = new UpdateRequest("book", "novel", id);
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("author", "lina").endObject();

            updateRequest.doc(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

        UpdateResponse response = this.client.update(updateRequest).get();

        return JSON.toJSONString(response);
    }

    @RequestMapping("query")
    @ResponseBody
    public String query(){
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.matchQuery("author", "jialei"));
        boolQuery.must(QueryBuilders.matchQuery("title", "aaas"));

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count");
        rangeQuery.from(3000).to(7000);

        boolQuery.filter(rangeQuery);
        SearchRequestBuilder builder = this.client.prepareSearch("bool")
                .setTypes("novel")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery);

        SearchResponse response = builder.get();

        return JSON.toJSONString(response.getHits());
    }
}