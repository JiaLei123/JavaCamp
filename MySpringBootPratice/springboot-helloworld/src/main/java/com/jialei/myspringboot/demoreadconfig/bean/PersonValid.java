package com.jialei.myspringboot.demoreadconfig.bean;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : Person.java, v 0.1 2019年09月19日 10:21 jialei Exp $
 */
@Data
@ToString
//@Component
//@Validated
//@ConfigurationProperties(prefix = "personValid")
public class PersonValid {

    @Email
    private String lastName;
    @Max(10)
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object>        lists;
    private Dog dog;
}