package com.cloud.provider.service.impl;

import com.cloud.provider.entity.Depart;
import com.cloud.provider.mapper.DepartRepository;
import com.cloud.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {

        Depart save = repository.save(depart);

        if (null != save) {
            return true;
        }

        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean modifyDepartById(Depart depart) {
        Depart save = repository.save(depart);

        if (null != save) {
            return true;
        }

        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        Depart referenceById = repository.getReferenceById(id);
        if (null == referenceById) {
            referenceById = new Depart();
            referenceById.setName("不存在");
        }

        return referenceById;
    }

    @Override
    public List<Depart> listAllDepart() {
        return repository.findAll();
    }
}
