package com.cloud.consumer.service;

import com.alibaba.fastjson2.JSONObject;
import com.cloud.consumer.entity.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FeignClient 指定消费的微服务名称  value标识被调用的FeignName
 */
@FeignClient(value = "provider-8082",path = "/provider/depart")
public interface DepartService {

    @PostMapping(value = "/save")
    public boolean saveHandle(@RequestBody Depart depart);


    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id);

    @PostMapping(value ="/update")
    public boolean updateHandle(@RequestBody Depart depart);


    @GetMapping("/list")
    public List<Depart> getList();


    @GetMapping("/client")
    public List<String> getClientList();


    @GetMapping("/test")
    public String check();


}
