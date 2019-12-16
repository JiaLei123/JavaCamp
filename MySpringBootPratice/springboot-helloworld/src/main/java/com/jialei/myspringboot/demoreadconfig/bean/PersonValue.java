package com.jialei.myspringboot.demoreadconfig.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jialei
 * @version : PersonValue.java, v 0.1 2019年09月19日 10:34 jialei Exp $
 */
@Data
@ToString
@Component
public class PersonValue {
    @Value("${person.lastName}")
    private String  lastName;
    @Value("#{11*12}")
    private Integer age;
    @Value("true")
    private Boolean boss;
    private Date    birth;

    private Map<String, Object> maps;
    private List<Object>        lists;
    private Dog                 dog;
}