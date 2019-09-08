package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dao.IUserDao2;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybaitsTest {
    private InputStream in = null;
    private SqlSession sqlSession = null;

    @Before
    public void init() throws IOException {
        this.in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        this.sqlSession = factory.openSession();
    }

    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        users.forEach(user-> System.out.println( user));

        IUserDao2 userDao2 = sqlSession.getMapper(IUserDao2.class);
        List<User> users2 = userDao2.findAll();
        users2.forEach(user-> System.out.println( user));
    }

    @Test
    public void testSaveUser() throws IOException {
        User user = new User();
        user.setUsername("Test Name");
        user.setAddress("Test Address");
        user.setSex("M");
        user.setBirthday(new Date());

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.saveUser(user);
        sqlSession.commit();

        List<User> users = userDao.findAll();
        users.forEach(a-> System.out.println(a));
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = new User();
        user.setId(60);
        user.setUsername("Test Update Name");
        user.setAddress("Test Update Address");
        user.setSex("M");
        user.setBirthday(new Date());

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.updateUser(user);
        sqlSession.commit();

        List<User> users = userDao.findAll();
        users.forEach(a-> System.out.println(a));
    }
}
