package jialei.com.spitter.dataaccess.springdata.controller;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.dataaccess.domain.SpittleDomain;
import jialei.com.spitter.dataaccess.jpa.repository.MyJpaRepository;
import jialei.com.spitter.dataaccess.springdata.repository.SpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("springdata")
public class SpringDataController {

    @Autowired
    private SpringDataRepository springDataRepository;

    @RequestMapping("find/{id}")
    public String findOne(@PathVariable("id") long id){
        SpittleDomain spittleDomain = springDataRepository.findOne(id);
        return JSON.toJSONString(spittleDomain);
    }

    @RequestMapping("like/{message}")
    public String linkOne(@PathVariable("message") String message){
        List<SpittleDomain> spittleDomains  = springDataRepository.readSpittleDomainByMessageContains(message);
        return JSON.toJSONString(spittleDomains);
    }

    @RequestMapping("findAll")
    public String findAll(){
        List<SpittleDomain> spittleDomains = springDataRepository.findAll();
        return JSON.toJSONString(spittleDomains);
    }
}
