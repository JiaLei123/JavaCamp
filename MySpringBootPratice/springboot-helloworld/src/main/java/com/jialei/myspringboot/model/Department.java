package com.jialei.myspringboot.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

/**
 *
 * @author jialei
 * @version : Department.java, v 0.1 2019年10月13日 15:39 jialei Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;

    //public Department(Integer id, String departmentName){
    //    this.id = id;
    //    this.departmentName = departmentName;
    //}

}