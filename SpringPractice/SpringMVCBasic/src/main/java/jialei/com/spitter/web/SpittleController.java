package jialei.com.spitter.web;

import jialei.com.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    private SpittleRepository spittleRepository;

//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository){
//        this.spittleRepository = spittleRepository;
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String spittles(Model model){

    }

}
