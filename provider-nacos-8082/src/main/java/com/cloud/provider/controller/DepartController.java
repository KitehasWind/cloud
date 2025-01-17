package com.cloud.provider.controller;

import com.cloud.provider.entity.Depart;
import com.cloud.provider.service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    private static final Logger log = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private DepartService departService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean addDepart(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }


    @GetMapping("del/{id}")
    public boolean deleteDepart(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }


    @PostMapping("/update")
    public boolean updateDepartById(@RequestBody Depart depart) {

        return departService.modifyDepartById(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getDepart(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }


    @GetMapping("/list")
    public List<Depart> list() {
        return departService.listAllDepart();
    }


    @GetMapping("/client/list")
    public List<String> getClientList() {
        List<String> services = client.getServices();
        log.info("获取到的service为 {}",services);
        services.forEach(s -> {
            List<ServiceInstance> instances = client.getInstances(s);
            log.info("获取指定微服务名称的所有实例 {} ",instances);
            instances.forEach(instance -> {
                Map<String,Object> map = new HashMap<>();
                map.put("serviceName",s);
                map.put("instanceId", instance.getInstanceId());
                map.put("host", instance.getHost());
                map.put("metadata", instance.getMetadata());
                map.put("uri", instance.getUri());
                map.put("scheme", instance.getScheme());
                map.put("port", instance.getPort());
                log.info("instance {} ", map);
            });



        });
        return services;
    }

}
