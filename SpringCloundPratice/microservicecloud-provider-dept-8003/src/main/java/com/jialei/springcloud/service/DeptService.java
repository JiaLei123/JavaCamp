package com.jialei.springcloud.service;

import com.jialei.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
