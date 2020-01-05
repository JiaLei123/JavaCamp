package com.jialei.myspringboot.demomybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author jialei
 * @version : User.java, v 0.1 2019年11月19日 11:02 上午 jialei Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private Integer id;

    private String roleName;

    private String roleDesc;

}