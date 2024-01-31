package com.example.boc.service;

import com.example.boc.Dao.CourrierDao;
import com.example.boc.model.Courrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourrierService {
    @Autowired
    CourrierDao courrierDao;

    public void addCourrier(Courrier courrier) {
        courrierDao.save(courrier);
    }

    public List<Courrier> getAllCourriers() {
        return courrierDao.findAll();
    }
}
