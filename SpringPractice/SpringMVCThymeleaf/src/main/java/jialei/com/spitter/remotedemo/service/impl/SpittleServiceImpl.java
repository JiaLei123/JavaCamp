package jialei.com.spitter.remotedemo.service.impl;

import jialei.com.spitter.service.SpittleService;
import org.springframework.stereotype.Service;


@Service
public class SpittleServiceImpl implements SpittleService {
    public String getAll(int number){
        return "Success";
    }
}
