package com.jialei.myspringboot.demomybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jialei
 * @version : User.java, v 0.1 2019年11月19日 11:02 上午 jialei Exp $
 */
@Data
@AllArgsConstructor
public class Role {
    private Integer id;

    private String roleName;

    private String roleDesc;

}