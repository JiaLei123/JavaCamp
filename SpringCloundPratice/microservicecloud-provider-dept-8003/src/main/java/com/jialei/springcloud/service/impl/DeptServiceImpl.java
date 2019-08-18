package com.jialei.springcloud.service.impl;

import com.jialei.springcloud.dao.DeptDao;
import com.jialei.springcloud.entities.Dept;
import com.jialei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean addDept(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return dao.findAll();
    }
}
