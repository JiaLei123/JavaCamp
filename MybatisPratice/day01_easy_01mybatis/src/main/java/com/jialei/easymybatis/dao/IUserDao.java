package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
