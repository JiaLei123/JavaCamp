package com.jialei.myspringboot.democache.controller;

import com.jialei.myspringboot.democache.service.RoleService;
import com.jialei.myspringboot.demomybatis.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jialei
 * @version : RoleController.java, v 0.1 2019年11月19日 11:11 上午 jialei Exp $
 */
@Controller
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("query/{id}")
    @ResponseBody
    public Role query(@PathVariable("id") int id){
        Role role = roleService.getRolebyId(id);
        return role;
    }

    @RequestMapping("insert")
    @ResponseBody
    public void insert(@RequestParam("id") Integer id, @RequestParam("roleName") String roleName,@RequestParam("roleDesc") String roleDesc){
        roleService.updateRole(new Role(id, roleName, roleDesc));
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Integer id){
        roleService.deleteRole(id);
    }


    @RequestMapping("query1/{id}")
    @ResponseBody
    public Role query1(@PathVariable("id") int id){
        Role role = roleService.getRolebyId1(id);
        return role;
    }

    @RequestMapping("query2/{id}")
    @ResponseBody
    public Role query2(@PathVariable("id") int id){
        Role role = roleService.getRolebyId2(id);
        return role;
    }

    @RequestMapping("query3/{id}")
    @ResponseBody
    public Role query3(@PathVariable("id") int id){
        Role role = roleService.getRolebyId3(id);
        return role;
    }

    @RequestMapping("query4/{id}")
    @ResponseBody
    public Role query4(@PathVariable("id") int id){
        Role role = roleService.getRolebyId4(id);
        return role;
    }




}