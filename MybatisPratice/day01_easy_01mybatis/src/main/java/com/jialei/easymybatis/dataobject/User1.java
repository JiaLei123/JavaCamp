/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dataobject;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *
 * @author jialei
 * @version : User1.java, v 0.1 2019年09月09日 18:07 jialei Exp $
 */
@ToString
@Data
public class User1 {
    private     Integer userId;
    private     String  userName;
    private     Date    userBirthday;
    private     String  userSex;
    private     String  userAddress;
}