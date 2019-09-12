/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dataobject;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 *
 * @author jialei
 * @version : Role.java, v 0.1 2019年09月11日 15:59 jialei Exp $
 */
@ToString
@Data
public class Role {
    private Integer id;
    private String name;
    private String desc;

    private List<User> users;
}