package jialei.com.spitter.remotedemo.service.impl;

import jialei.com.spitter.service.HttpInvokerSpittleService;
import org.springframework.stereotype.Service;

@Service
public class HttpInvokerSpittleServiceImpl implements HttpInvokerSpittleService {
    @Override
    public String getAll(int number) {
        return "HTTP Invoker Success";
    }
}
