package com.jialei.easymybatis.dataobject;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Data
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
