/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jialei.myspringboot.demoelasticsearch.repository;

import com.jialei.myspringboot.demoelasticsearch.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jialei
 * @version : BookRepository.java, v 0.1 2020年01月26日 6:30 下午 jialei Exp $
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

}