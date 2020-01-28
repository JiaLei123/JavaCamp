package com.jialei.myspringboot.demoelasticsearch;

import com.jialei.myspringboot.demoelasticsearch.model.Book;
import com.jialei.myspringboot.demoelasticsearch.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author jialei
 * @version : ElasticSearchForSpringDataTest.java, v 0.1 2020年01月27日 11:21 上午 jialei Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchForSpringDataTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveData(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("jialei");
        book.setTitle("test Case");
        book.setWord_count(3000);
        bookRepository.index(book);

        Book savedBook = bookRepository.findOne(1);
        Assert.assertEquals(savedBook.getTitle(), book.getTitle());
    }


}