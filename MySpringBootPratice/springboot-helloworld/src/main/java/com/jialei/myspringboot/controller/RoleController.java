/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.controller;

import com.jialei.myspringboot.dao.RoleDao;
import com.jialei.myspringboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : RoleController.java, v 0.1 2019年11月19日 11:11 上午 jialei Exp $
 */
@Controller
@RequestMapping("mybatis")
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @RequestMapping("query/{id}")
    @ResponseBody
    public Role query(@PathVariable("id") int id){
        Role role = null;
        try{
            role = roleDao.getById(id);
        } catch (Exception e){
            System.out.println(e);
        }

        return role;
    }

    @RequestMapping("insert")
    @ResponseBody
    public void insert(@RequestBody Role role){
        roleDao.insert(role);
    }


}