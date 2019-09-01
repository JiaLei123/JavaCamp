package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dao.IUserDao2;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybaitsTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        users.forEach(user-> System.out.println( user));

        IUserDao2 userDao2 = session.getMapper(IUserDao2.class);
        List<User> users2 = userDao2.findAll();
        users2.forEach(user-> System.out.println( user));

        session.close();
        in.close();
    }
}
