package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dao.IUserDao2;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class MybaitsAnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class daoClass = Class.forName("com.jialei.easymybatis.dao.IUserDao2");
        Method method = daoClass.getMethod("findAll");
        boolean isAnno = method.isAnnotationPresent(Select.class);
        if(isAnno){
            Select selectAnno = method.getAnnotation(Select.class);
            String[] queryString = selectAnno.value();
            Type type = method.getGenericReturnType();
            if(type instanceof ParameterizedType){
                ParameterizedType ptype = (ParameterizedType) type;
                Type[] types = ptype.getActualTypeArguments();
                System.out.println(types.toString());
            }
        }



    }
}
