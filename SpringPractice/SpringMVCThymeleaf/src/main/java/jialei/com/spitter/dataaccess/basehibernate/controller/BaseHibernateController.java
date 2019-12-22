package jialei.com.spitter.dataaccess.basehibernate.controller;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.dataaccess.domain.SpittleDomain;
import jialei.com.spitter.dataaccess.basehibernate.repository.BaseHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author jialei
 * @version : SQLController.java, v 0.1 2019年11月28日 10:23 上午 jialei Exp $
 */
@RestController
@RequestMapping("sql")
public class BaseHibernateController {
    @Autowired
    private BaseHibernateRepository hibernateRepository;

    @RequestMapping("findAll")
    @ResponseBody
    public List<SpittleDomain> finAll(){
        return hibernateRepository.finAll();
    }

    @RequestMapping("find/{id}")
    public String findOne(@PathVariable("id") long id){
        SpittleDomain spittleDomain = hibernateRepository.findOne(id);
        return JSON.toJSONString(spittleDomain);
    }
}