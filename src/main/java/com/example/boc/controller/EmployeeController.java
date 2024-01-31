package com.example.boc.controller;

import com.example.boc.model.Employe;
import com.example.boc.model.ServiceModel;
import com.example.boc.service.EmployeeService;
import com.example.boc.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceService serviceService;
    @GetMapping("emp/listEmp")
    public List<Employe> getEmployees() {
        return employeeService.getEmployees();
    }

    @PutMapping("emp/addEmp")
    public ResponseEntity<String> addEmployee(@RequestBody Employe emp) {
        try {
            // Check if the service exists before proceeding
            ServiceModel serviceModel = serviceService.getServiceById(emp.getService().getCodserv());
            if (serviceModel == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
            }

            // Set the service for the employee
            emp.setService(serviceModel);

            // Save the employee
            employeeService.addEmployee(emp);

            return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @DeleteMapping("emp/supprime/{codemp}")
    public ResponseEntity<?> suppEmp(@PathVariable Integer codemp) {
        return employeeService.SuppEmp(codemp);
    }
}
