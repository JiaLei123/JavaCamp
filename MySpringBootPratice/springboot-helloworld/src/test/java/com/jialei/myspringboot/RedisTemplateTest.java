package com.jialei.myspringboot;

import com.jialei.myspringboot.demomybatis.Dao.RoleDao;
import com.jialei.myspringboot.demomybatis.model.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate myRedisTemplate;

    @Test
    public void test01(){
        stringRedisTemplate.opsForValue().set("test", "test");
        String value = stringRedisTemplate.opsForValue().get("test");
        Assert.assertEquals(value, "test");
    }

    @Test
    public void test02(){
        stringRedisTemplate.opsForValue().append("test", "test");
        String value = stringRedisTemplate.opsForValue().get("test");
        Assert.assertEquals(value, "testtest");
    }

    @Test
    public void test03(){
        Role role = roleDao.getById(1);
        myRedisTemplate.opsForValue().set("test01", role);
        Role value = (Role) myRedisTemplate.opsForValue().get("test01");
        Assert.assertEquals(role.getRoleName(), value.getRoleName());
    }
}
