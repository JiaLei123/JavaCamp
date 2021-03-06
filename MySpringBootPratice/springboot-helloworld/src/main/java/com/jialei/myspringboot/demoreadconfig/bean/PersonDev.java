package com.jialei.myspringboot.demoreadconfig.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
@Component
@ConfigurationProperties(prefix = "persondev")
public class PersonDev {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object>        lists;
    private Dog dog;
}