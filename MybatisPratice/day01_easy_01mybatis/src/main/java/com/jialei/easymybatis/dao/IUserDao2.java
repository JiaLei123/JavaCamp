package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao2 {
    @Select("select * from user")
    List<User> findAll();
}
