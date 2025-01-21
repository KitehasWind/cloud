package com.cloud.consumer.controller;

import com.alibaba.fastjson2.JSONObject;
import com.cloud.consumer.entity.Depart;
import com.cloud.consumer.service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private DepartService departService;


    private static final Logger log = LoggerFactory.getLogger(DepartController.class);



    @PostMapping(value = "/save")
    public boolean saveHandle(@RequestBody Depart depart){
        return departService.saveHandle(depart);
    }


    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id){
        boolean b = departService.deleteHandle(id);
        return false;
    }

    @PostMapping(value ="/update")
    public boolean updateHandle(@RequestBody Depart depart){
        boolean b = departService.updateHandle(depart);
        return b;
    }


    @GetMapping("/list")
    public List<Depart> getList(){
        List<Depart> list = departService.getList();

        return list;
    }

    @GetMapping("/client")
    public List<String> getClientList(){
        List<String> clientList = departService.getClientList();
        return clientList;
    }




}
