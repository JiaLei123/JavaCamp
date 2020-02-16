package jialei.com.spitter.myhttpinvokerclient;

import jialei.com.spitter.service.HttpInvokerSpittleService;
import jialei.com.spitter.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/remote1")
public class RemoteHttpInvokerSpittleController {

    @Autowired
    private HttpInvokerSpittleService httpInvokerSpittleService;

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String spittlesAll(){
        String result =  httpInvokerSpittleService.getAll(20);
        return result;
    }
}
