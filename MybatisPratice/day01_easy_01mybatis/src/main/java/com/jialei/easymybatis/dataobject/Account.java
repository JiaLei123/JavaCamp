/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dataobject;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author jialei
 * @version : Account.java, v 0.1 2019年09月10日 11:26 jialei Exp $
 */
@ToString
@Data
public class Account {
    private Integer id;
    private Integer uid;
    private double money;
}