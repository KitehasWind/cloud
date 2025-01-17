package com.cloud.consumer.controller;

import com.alibaba.fastjson2.JSONObject;
import com.cloud.consumer.entity.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DEFAULT_SERVER ="http://localhost:8081/provider/depart";


    @PostMapping(value = "/save")
    public boolean saveHandle(@RequestBody Depart depart){
        String url = DEFAULT_SERVER+"/save";
//        return restTemplate.postForObject(url, depart, Boolean.class);
        return restTemplate.postForObject(url, JSONObject.from(depart), Boolean.class);
    }


    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id){
        String url = DEFAULT_SERVER+"/del"+id;
        restTemplate.delete(url);
        return false;
    }

    @PostMapping(value ="/update")
    public boolean updateHandle(@RequestBody Depart depart){
        String url = DEFAULT_SERVER +"/update";
        Boolean b = restTemplate.postForObject(url, depart, Boolean.class);
        return b;
    }


    @GetMapping("/list")
    public List<Depart> getList(){
        String url = DEFAULT_SERVER +"/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }




}
