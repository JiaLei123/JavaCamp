package com.jialei.springcloud.service;

import com.jialei.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                return new Dept().setDepNo(id).setDName("该ID" + id + "没有对应的信息").setDName("no this DB in MySQL");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
