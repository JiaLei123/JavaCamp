package jialei.com.spitter.web;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.demosecurity.server.SecurityServer;
import jialei.com.spitter.repository.SpittleRepository;
import jialei.com.spitter.model.DuplicateSpittleException;
import jialei.com.spitter.model.Spittle;
import jialei.com.spitter.model.SpittleNotFoundException;
import jialei.com.spitter.model.SpittleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
//    @Autowired
    private SpittleRepository spittleRepository;

    //used to test 基于方法级别的安全验证
    @Autowired
    private SecurityServer securityServer;


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
    @ResponseBody
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
        Spittle spittle = spittleRepository.findOne(spittleId);
        if(null == spittle){
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String spittleDetail(@RequestParam("message") String message, Model model){
        List<Spittle> spittles = spittleRepository.findSpittles(message);
        if(null == spittles){
            throw new SpittleNotFoundException();
        }
        model.addAttribute("spittleList", spittles);
        return "spittleList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String saveSpittle(@Valid SpittleVO form, Errors errors, Model model) throws Exception {
        if(errors.hasErrors()){
            return "errors";
        }
        spittleRepository.save(new Spittle(form.getMessage(), new Date()));
        return "redirect:/spittles";
    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicteSpittle(){
        return "error/duplicate";
    }

    /**
     * 获取方法级别的安全验证
     * @return
     */
    @RequestMapping(value = "/squery", method = RequestMethod.GET)
    public String queryWithSecurity(){
        securityServer.getMessage();
        return "spittleList";
    }
}
