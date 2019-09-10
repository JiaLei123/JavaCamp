package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.VO.QueryVO;
import com.jialei.easymybatis.dataobject.User;
import com.jialei.easymybatis.dataobject.User1;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void saveUser2(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User findById(int userId);

    List<User> findByName(String name);

    List<User> findByQueryVO(QueryVO queryVO);

    List<User> findByCondition(User user);

    List<User> findByCondition1(User user);

    List<User> findByIds(QueryVO queryVO);
}
