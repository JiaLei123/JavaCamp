/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.controller;

import com.jialei.myspringboot.dao.DepartmentDao;
import com.jialei.myspringboot.dao.EmployeeDao;
import com.jialei.myspringboot.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 *
 * @author jialei
 * @version : EmployeeController.java, v 0.1 2019年10月17日 10:40 jialei Exp $
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("emps")
    public String list(Model model){
        model.addAttribute("emps", employeeDao.getAll());
        //thymeleaf 默认会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    @GetMapping("emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

}