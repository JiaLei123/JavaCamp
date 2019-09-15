package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.Account;
import com.jialei.easymybatis.dataobject.User;
import com.jialei.easymybatis.dataobject.User1;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.plugin.Intercepts;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IUserAnnotationDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, address, sex, birthday) values (#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username}, address=#{address}, sex=#{sex}, birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    void deleteUser(Integer id);

    @Select("select * from user")
    @Results( id = "userMap", value = {@Result(property = "userName", column = "username"),
            @Result(property = "userId", column = "id", id = true),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "userBirthday", column = "birthday")})
    List<User1> findAllUser1();

    @Select("select * from user where id =#{id}")
    User findById(Integer id);

    @Select("select * from user")
    @Results( id = "accountMap", value = {@Result(property = "username", column = "username"),
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "accounts", column = "id", many=@Many(select = "com.jialei.easymybatis.dao.IAccountAnnotationDao.findByUId", fetchType = FetchType.LAZY))})
    List<User> findAllUserAccount();
}
