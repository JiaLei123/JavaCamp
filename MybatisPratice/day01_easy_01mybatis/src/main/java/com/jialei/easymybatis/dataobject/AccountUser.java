/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dataobject;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author jialei
 * @version : AccountUser.java, v 0.1 2019年09月10日 12:10 jialei Exp $
 */
@ToString
@Data
public class AccountUser extends Account {
    private String username;
    private String address;
}