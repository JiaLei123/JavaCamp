/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.jialei.effictivejava;

import java.util.Comparator;

/**
 * @author jialei
 * @version : CloneObject.java, v 0.1 2021年05月31日 11:57 下午 jialei Exp $
 */
public class DemoCloneObject implements Cloneable{

    private final String name;

    //@Override
    //protected Object clone() {
    //    return super.clone();
    //}

    public DemoCloneObject(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        DemoCloneObject testOjb = null;
        DemoCloneObject obj = new DemoCloneObject("Test");
        try {
            testOjb = (DemoCloneObject)obj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(testOjb);
    }

}