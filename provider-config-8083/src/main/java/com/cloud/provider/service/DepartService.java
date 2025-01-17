package com.cloud.provider.service;

import com.cloud.provider.entity.Depart;

import java.util.List;

public interface DepartService {

    boolean saveDepart(Depart depart);


    boolean removeDepartById(int id);

    boolean modifyDepartById(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDepart();


}
