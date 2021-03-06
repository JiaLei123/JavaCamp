package com.jialei.myspringboot.demojpa.repository;

import com.jialei.myspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jialei
 * @version : UserRepository.java, v 0.1 2019年11月21日 10:33 上午 jialei Exp $
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}