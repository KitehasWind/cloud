package com.cloud.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
    //切换成微服务模式 - 名称从nacos中取
    private static final String DEFAULT_SERVER ="http://provider-8082/provider/depart";


    @PostMapping(value = "/save")
    public boolean saveHandle(@RequestBody Depart depart){
        String url = DEFAULT_SERVER+"/save";
//        return restTemplate.postForObject(url, depart, Boolean.class);
        return restTemplate.postForObject(url, JSONObject.from(depart), Boolean.class);
    }



    @GetMapping(value = "/get/{id}")
    @SentinelResource(fallback = "getHandleFallBack")
    public Depart getHandle(@PathVariable("id") int id){
        String url = DEFAULT_SERVER+"/get/"+id;
        return restTemplate.getForObject(url, Depart.class);
    }

    /**
     * 定义降级处理方法
     * @param
     * @return
     */
    public Depart getHandleFallBack(int id , Throwable e){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("degrade - method "+ id +"- 获取数据失败"+e.getMessage());
        return depart;
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


    @GetMapping("/client")
    public List<String> getClientList(){
        String url = DEFAULT_SERVER +"/client/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }



}
