package com.example.boc.controller;

import com.example.boc.model.Courrier;
import com.example.boc.service.CourrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CourrierController {
    @Autowired
    CourrierService courrierService;
    @PostMapping("addCourrier")
    public void addCourrier(Courrier courrier){
        courrierService.addCourrier(courrier);
    }
    @GetMapping("ListCourriers")
    public List<Courrier> getAllCourriers(){
        return courrierService.getAllCourriers();
    }

}



