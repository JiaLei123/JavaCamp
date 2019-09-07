package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dao.IUserDao2;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybaitsTest {

    private void init(){

    }

    @Test
    public void testFindAll() throws IOException {
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

    @Test
    public void testSaveUser() throws IOException {
        User user = new User();
        user.setUsername("Test Name");
        user.setAddress("Test Address");
        user.setSex("M");
        user.setBirthday(new Date());

        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        userDao.saveUser(user);

        List<User> users = userDao.findAll();
        users.forEach(a-> System.out.println(a));
        session.close();
        in.close();
    }
}
