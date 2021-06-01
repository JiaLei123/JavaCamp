package jialei.com.spitter.demorest.controller;

import jialei.com.spitter.model.Spittle;
import jialei.com.spitter.model.SpittleNotFoundException;
import jialei.com.spitter.model.SpittleVO;
import jialei.com.spitter.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/webapi")
public class MyController {
    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(value = "spittles", method = RequestMethod.GET)
    @ResponseBody
    public List<Spittle> spittles(){
        return spittleRepository.findSpittles(20);
    }

    @RequestMapping(value = "getOne", method = RequestMethod.GET)
    @ResponseBody
    public Spittle spittle(){
        return spittleRepository.findOne(1);
    }

    @RequestMapping(value = "spittles", method = RequestMethod.POST)
    public Spittle saveSpittle(@RequestBody Spittle spittle){
        spittle.setTime(new Date());
        spittleRepository.save(spittle);
        return spittle;
    }

    @RequestMapping(value = "spittles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Spittle> findById1(@PathVariable long id){
        Spittle spittle = spittleRepository.findOne(id);
        HttpStatus status = spittle != null? HttpStatus.OK : HttpStatus.NOT_FOUND;
        if(spittle != null){
            HttpHeaders headers = new HttpHeaders();
            URI locationUri = URI.create("http://localhost:8080/webapi/spittles/" + spittle.getId());
            headers.setLocation(locationUri);
            return new ResponseEntity<Spittle>(spittle, headers, status);
        }else {
            return new ResponseEntity<Spittle>(spittle, status);
        }
    }

    @RequestMapping(value = "spittles2/{id}", method = RequestMethod.GET)
    public ResponseEntity<Spittle> findById2(@PathVariable long id, UriComponentsBuilder ucb){
        Spittle spittle = spittleRepository.findOne(id);
        if(spittle == null){
            throw new SpittleNotFoundException();
        }
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/webapi/spittles/").path(String.valueOf(spittle.getId())).build().toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<Spittle>(spittle, headers, HttpStatus.OK);
    }
}
