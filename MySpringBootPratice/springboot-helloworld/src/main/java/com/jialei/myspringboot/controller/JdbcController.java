package com.jialei.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : JdbcController.java, v 0.1 2019年11月12日 10:45 上午 jialei Exp $
 */
@RequestMapping("jdbc")
@Controller
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("query")
    @ResponseBody
    public Map<String, Object> query(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list.get(0);
    }
}