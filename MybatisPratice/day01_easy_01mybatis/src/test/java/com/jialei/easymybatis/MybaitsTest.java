package com.jialei.easymybatis;

import com.jialei.easymybatis.VO.QueryVO;
import com.jialei.easymybatis.dao.IAccountDao;
import com.jialei.easymybatis.dao.IRoleDao;
import com.jialei.easymybatis.dao.IUserDao;
import com.jialei.easymybatis.dao.IUserDao2;
import com.jialei.easymybatis.dataobject.Account;
import com.jialei.easymybatis.dataobject.AccountUser;
import com.jialei.easymybatis.dataobject.Role;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

        System.out.println(user);
    }

    @Test
    public void testSaveUser2() throws IOException {
        User user = new User();
        user.setUsername("Test2 Name");
        user.setAddress("Test2 Address");
        user.setSex("M");
        user.setBirthday(new Date());

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.saveUser2(user);
        sqlSession.commit();

        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = new User();
        user.setId(45);
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

    @Test
    public void testDeleteUser(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.deleteUser(45);
        sqlSession.commit();

        List<User> users = userDao.findAll();
        users.forEach(a-> System.out.println(a));

    }

    @Test
    public void testFindById(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.findById(41);
        System.out.println(user);

    }


    @Test
    public void testFindByName(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findByName("%老王%");
        users.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindByQueryVO(){
        QueryVO queryVO = new QueryVO();
        User user = new User();
        user.setUsername("老王");
        queryVO.setUser(user);

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findByQueryVO(queryVO);
        users.forEach(a-> System.out.println(a));
    }


    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUsername("老王");

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findByCondition(user);
        users.forEach(a-> System.out.println(a));
    }


    @Test
    public void testFindByCondition1(){
        User user = new User();
        user.setUsername("老王");
        user.setSex("男");

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findByCondition1(user);
        users.forEach(a-> System.out.println(a));
    }

    @Test
    public void findByIds(){
        QueryVO queryVO = new QueryVO();
        User user = new User();
        user.setUsername("老王");
        //queryVO.setUser(user);
        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        queryVO.setIds(ids);

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findByIds(queryVO);
        users.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllAccount(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accounts = accountDao.findAll();
        accounts.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllAccount1(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accounts = accountDao.findAllAccountUser1();
        for (Account account : accounts) {
            System.out.println(account);
            //System.out.println(account.getUser());
        }
    }


    @Test
    public void testFindAllAccountUser(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<AccountUser> accounts = accountDao.findAllAccountUser();
        accounts.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllUserAccount(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> accounts = userDao.findAllUserAccount();
        accounts.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllRole(){
        IRoleDao roleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> roles = roleDao.findAll();
        roles.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllUserRole(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> accounts = userDao.findAllUserRole();
        accounts.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindAllUserAccountLazy(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAllUserAccountLazy();
        //users.forEach(a-> System.out.println(a));
    }
}
