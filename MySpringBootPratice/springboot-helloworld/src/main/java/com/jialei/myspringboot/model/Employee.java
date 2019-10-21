package com.jialei.myspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 * @author jialei
 * @version : Employee.java, v 0.1 2019年10月13日 15:39 jialei Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer    id;
    private String     lastName;
    private String     email;
    private Integer    gender;
    private Department department;
    private Date       birth;

    //public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth){
    //    this.id=id;
    //    this.lastName = lastName;
    //    this.email =email;
    //    this.gender = gender;
    //    this.department = department;
    //    this.birth = birth;
    //}
}