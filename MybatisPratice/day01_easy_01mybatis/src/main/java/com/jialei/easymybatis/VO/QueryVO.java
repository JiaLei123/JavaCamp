/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.VO;

import com.jialei.easymybatis.dataobject.User;
import lombok.Data;

import java.util.List;

/**
 *
 * @author jialei
 * @version : QueryVO.java, v 0.1 2019年09月09日 12:01 jialei Exp $
 */
@Data
public class QueryVO {
    private User user;
    private List<Integer> ids;
 }