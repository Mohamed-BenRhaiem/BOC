package com.example.boc.controller;

import com.example.boc.model.ServiceModel;
import com.example.boc.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("services")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @GetMapping("/allServices")
    public List<ServiceModel> getAllServices(){
        return serviceService.getAllServices();
    }


    @PostMapping("addService")
    public ResponseEntity<String> addService(@RequestBody ServiceModel service) {
        serviceService.addService(service);
        return ResponseEntity.ok("Service added successfully");
    }


}
