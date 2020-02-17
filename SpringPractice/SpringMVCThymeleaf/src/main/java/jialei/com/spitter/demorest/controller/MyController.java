package jialei.com.spitter.demorest.controller;

import jialei.com.spitter.model.Spittle;
import jialei.com.spitter.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.ConfigFile;

import java.util.List;

@RestController
@RequestMapping("/webapi")
public class MyController {
    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Spittle> spittles(){
        return spittleRepository.findSpittles(20);
    }

    @RequestMapping(value = "getOne", method = RequestMethod.GET)
    @ResponseBody
    public Spittle spittle(){
        return spittleRepository.findOne(1);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Spittle saveSpittle(@RequestBody Spittle spittle){
        spittleRepository.save(spittle);
        return spittle;
    }

    @RequestMapping(value = "getOne/{id}", method = RequestMethod.GET)
    public ResponseEntity<Spittle> findById1(@PathVariable long id){
        Spittle spittle = spittleRepository.findOne(id);
        HttpStatus status = spittle != null? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Spittle>(spittle, status);
    }
}
