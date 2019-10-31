package jialei.com.spitter.web;

import jialei.com.spitter.data.SpitterRepository;
import jialei.com.spitter.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/jialei/com/spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegistrationFrom(Model model){
        model.addAttribute(new Spitter());
        return "registerFrom";
    }

    @RequestMapping(value = "registerMultipartFile", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, @RequestPart("profilePicture") MultipartFile profilePicture, Errors errors) throws IOException {
        if(errors.hasErrors()){
            return "registerFrom";
        }
        profilePicture.transferTo(new File("/data/jialei.com.spitter" + profilePicture.getOriginalFilename()));

        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IOException {
        if(errors.hasErrors()){
            return "registerFrom";
        }
        spitterRepository.save(spitter);
        model.addAttribute("userName", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        if(!model.containsAttribute("jialei/com/spitter")){
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
        }
        return "profile";
    }
}
