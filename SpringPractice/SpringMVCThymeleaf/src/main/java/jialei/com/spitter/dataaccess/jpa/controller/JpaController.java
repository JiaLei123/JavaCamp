package jialei.com.spitter.dataaccess.jpa.controller;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.dataaccess.domain.SpittleDomain;
import jialei.com.spitter.dataaccess.jpa.repository.MyJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpa_repository")
public class JpaController
{
    @Autowired
    private MyJpaRepository jpaRepository;

    @RequestMapping("find/{id}")
    public String findOne(@PathVariable("id") long id){
        SpittleDomain spittleDomain = jpaRepository.findOne(id);
        return JSON.toJSONString(spittleDomain);
    }
}
