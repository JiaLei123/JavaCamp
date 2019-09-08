package jialei.com.spitter.web;

import jialei.com.spitter.Spitter;
import jialei.com.spitter.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegistrationFrom(){
        return "registerFrom";
    }

    @RequestMapping(value = "registerNew", method = RequestMethod.GET)
    public String showRegistrationFromNew(){
        return "registerFromNew";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerFrom";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "registerNew", method = RequestMethod.POST)
    public String processRegistrationNew(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerFromNew";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
