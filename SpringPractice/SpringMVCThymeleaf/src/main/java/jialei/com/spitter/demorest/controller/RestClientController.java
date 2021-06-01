package jialei.com.spitter.demorest.controller;

import jialei.com.spitter.model.Spittle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/webapiClient")
public class RestClientController {

    @RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
    public Spittle findById1(@PathVariable long id){
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://localhost:8080/webapi/spittles/{spitter}", Spittle.class, id);
    }

    @RequestMapping(value = "findOne2/{id}", method = RequestMethod.GET)
    public HttpStatus findById2(@PathVariable long id){
        RestTemplate rest = new RestTemplate();
        return rest.getForEntity("http://localhost:8080/webapi/spittles/{spitter}", Spittle.class, id).getStatusCode();
    }

    @RequestMapping(value = "findOne3/{id}", method = RequestMethod.GET)
    public ResponseEntity findById_exchange(@PathVariable long id){
        RestTemplate rest = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
        return rest.exchange("http://localhost:8080/webapi/spittles/{spitter}", HttpMethod.GET, requestEntity, Spittle.class, id);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Spittle add(@RequestBody Spittle spittle){
        RestTemplate rest = new RestTemplate();
        return rest.postForObject("http://localhost:8080/webapi/spittles/", spittle, Spittle.class);
    }

    @RequestMapping(value = "add2", method = RequestMethod.POST)
    public URI add2(@RequestBody Spittle spittle){
        RestTemplate rest = new RestTemplate();
        return rest.postForLocation("http://localhost:8080/webapi/spittles/", spittle, Spittle.class);
    }


//    @RequestMapping(value = "addOne", method = RequestMethod.POST)
//    public Spittle saveSpittle(@RequestBody Spittle spittle){
//        RestTemplate rest = new RestTemplate();
//
//        return rest.getForObject("");
//    }

}
