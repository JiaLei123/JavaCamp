package com.jialei.myspringboot;

import com.jialei.myspringboot.dao.DepartmentDao;
import com.jialei.myspringboot.dao.EmployeeDao;
import com.jialei.myspringboot.model.Department;
import com.jialei.myspringboot.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author jialei
 * @version : DaoTest.java, v 0.1 2019年10月22日 17:02 jialei Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {


    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void contextLoads() {
        Department department = new Department();
        department.setId(103);

        Employee employee = new Employee();
        employee.setLastName("test");
        employee.setGender(1);
        employee.setDepartment(department);
        employeeDao.save(employee);
        //Assert.assertEquals(employeeDao.getAll().size(), 6);
    }


}