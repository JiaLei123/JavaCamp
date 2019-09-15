package com.jialei.easymybatis;

import com.jialei.easymybatis.dao.IUser1Dao;
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
import java.util.List;

public class MybaitsUser1Test {
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
    public void testFindAll1() throws IOException {
        IUser1Dao userDao = sqlSession.getMapper(IUser1Dao.class);
        List<User1> users = userDao.findAll1();
        users.forEach(user-> System.out.println( user));
    }

}
