package springcloud.controller;

import com.jialei.springcloud.entities.Dept;
import com.jialei.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping(value = "consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "consumer/dept/list")
    public List<Dept> list(){
        return service.findAll();
    }

}
