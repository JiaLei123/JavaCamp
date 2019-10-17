package com.jialei.myspringboot.dao;

import com.jialei.myspringboot.model.Department;
import com.jialei.myspringboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : EmployeeDao.java, v 0.1 2019年10月13日 15:38 jialei Exp $
 */

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>(5);
        employees.put(1001, new Employee(1001, "E-AA", "aa@example.com", 1, new Department(101, "D-AA"), new Date()));
        employees.put(1002, new Employee(1002, "E-BB", "bb@example.com", 0, new Department(102, "D-BB"), new Date()));
        employees.put(1003, new Employee(1003, "E-CC", "cc@example.com", 0, new Department(103, "D-CC"), new Date()));
        employees.put(1004, new Employee(1004, "E-DD", "dd@example.com", 1, new Department(104, "D-DD"), new Date()));
        employees.put(1005, new Employee(1005, "E-EE", "ee@example.com", 1, new Department(105, "D-EE"), new Date()));
    }

    private Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getdepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id){
        return employees.getOrDefault(id, null);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}