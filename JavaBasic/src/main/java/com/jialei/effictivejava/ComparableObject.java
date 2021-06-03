/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.jialei.effictivejava;

import java.util.Comparator;

/**
 * @author jialei
 * @version : ComparableObject.java, v 0.1 2021年06月03日 10:40 上午 jialei Exp $
 */
public class ComparableObject implements Comparable<ComparableObject> {

    private final String name;
    private final int    number;
    private final double price;

    public ComparableObject(String name, int num, double price) {
        this.name = name;
        this.number = num;
        this.price = price;
    }

    private static final Comparator<ComparableObject> COMPARATOR = Comparator.comparingInt((ComparableObject pn) -> pn.number)
            .thenComparingDouble(pn->pn.price)
            .thenComparing(pn->pn.name);

    @Override
    public int compareTo(ComparableObject o) {
        return COMPARATOR.compare(this, o);
    }
}