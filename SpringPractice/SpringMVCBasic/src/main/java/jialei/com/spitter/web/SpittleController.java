package jialei.com.spitter.web;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.data.SpittleRepository;
import jialei.com.spitter.model.Spittle;
import jialei.com.spitter.model.SpittleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Date;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
//    @Autowired
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    /**
     * Test only
     * @return
     */

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    public String spittlesAll(Model model){
        model.addAttribute(spittleRepository.findSpittles(20));
        return "spittles";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String spittlesName(Model model){
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String spittlesName(){
        return JSON.toJSONString(spittleRepository.findSpittles(Long.MAX_VALUE, 20)) ;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittlesName(@RequestParam(value = "max", defaultValue = "100000000") long max,
                                      @RequestParam(value = "count", defaultValue = "20") int count){
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("spittleId") Long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String saveSpittle(@Valid SpittleVO form, Errors errors, Model model) throws Exception {
        if(errors.hasErrors()){
            return "errors";
        }
        spittleRepository.save(new Spittle(form.getMessage(), new Date()));
        return "redirect:/spittles";
    }
}
