package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.Account;
import com.jialei.easymybatis.dataobject.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountAnnotationDao {

    @Select("select * from account")
    @Results( id = "accountMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", one=@One(select = "com.jialei.easymybatis.dao.IUserAnnotationDao.findById", fetchType = FetchType.EAGER))})
    List<Account> findAll();

    @Select("select * from account where uid =#{uid}")
    User findByUId(Integer uid);
}
