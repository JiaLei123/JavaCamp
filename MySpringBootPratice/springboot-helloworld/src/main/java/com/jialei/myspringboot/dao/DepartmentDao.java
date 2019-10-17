package com.jialei.myspringboot.dao;

import com.jialei.myspringboot.model.Department;
import com.jialei.myspringboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : DepartmentDao.java, v 0.1 2019年10月17日 10:43 jialei Exp $
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;


    static {
        departments = new HashMap<>(4);
        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));

    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getdepartment(Integer id){
        return departments.getOrDefault(id, null);
    }
}