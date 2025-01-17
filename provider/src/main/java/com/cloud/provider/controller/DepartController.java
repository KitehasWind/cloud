package com.cloud.provider.controller;

import com.cloud.provider.entity.Depart;
import com.cloud.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

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

}
