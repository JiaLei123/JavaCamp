package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IAccountAnnotationDao;
import com.jialei.easymybatis.dao.IUser1Dao;
import com.jialei.easymybatis.dao.IUserAnnotationDao;
import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dataobject.Account;
import com.jialei.easymybatis.dataobject.User;
import com.jialei.easymybatis.dataobject.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybaitsAnnotationTest {
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
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);
        List<User> users = userAnnotationDao.findAll();
        users.forEach(user-> System.out.println( user));
    }

    @Test
    public void testSaveUser() throws IOException {
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);
        User user = new User();
        user.setUsername("Annotation test Name");
        user.setAddress("Annotation Test Address");
        user.setSex("M");
        user.setBirthday(new Date());

        userAnnotationDao.saveUser(user);

        sqlSession.commit();

        List<User> users = userAnnotationDao.findAll();
        users.forEach(a-> System.out.println( a));
    }

    @Test
    public void testUpdateUser() throws IOException {
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);
        User user = new User();
        user.setId(63);
        user.setUsername("Annotation test Modify Name");
        user.setAddress("Annotation Test Modify Address");
        user.setSex("M");
        user.setBirthday(new Date());

        userAnnotationDao.updateUser(user);

        List<User> users = userAnnotationDao.findAll();
        users.forEach(a-> System.out.println( a));
    }

    @Test
    public void testDeleteUser() throws IOException {
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);

        userAnnotationDao.deleteUser(64);

        sqlSession.commit();
        List<User> users = userAnnotationDao.findAll();
        users.forEach(a-> System.out.println( a));
    }

    @Test
    public void testFindAllUser1() throws IOException {
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);
        List<User1> users = userAnnotationDao.findAllUser1();
        users.forEach(user-> System.out.println( user));
    }

    @Test
    public void testFindAllAccount() throws IOException {
        IAccountAnnotationDao accountAnnotationDao = sqlSession.getMapper(IAccountAnnotationDao.class);
        List<Account> accounts = accountAnnotationDao.findAll();
        accounts.forEach(a-> System.out.println( a));
    }

    @Test
    public void testFindAllUserAccount() throws IOException {
        IUserAnnotationDao userAnnotationDao = sqlSession.getMapper(IUserAnnotationDao.class);
        List<User> users = userAnnotationDao.findAllUserAccount();
        users.forEach(user-> System.out.println( user));
    }
}
