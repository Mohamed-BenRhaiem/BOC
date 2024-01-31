package com.example.boc.service;

import com.example.boc.Dao.EmployeDao;
import com.example.boc.Dao.ServiceDao;
import com.example.boc.model.Employe;
import com.example.boc.model.Responsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeDao employeDao;
    @Autowired
    ServiceDao serviceDao;
    @Autowired
    ResponsableService responsableService;

    public List<Employe> getEmployees(){
        return employeDao.findAll();

    }
    
    public void addEmployee(Employe emp){
        employeDao.save(emp);
    }

    public Integer getCodServByEmployee(String nomserv) {
        return  employeDao.getCodServByEmployee(nomserv);
    }

    public Employe getEmployeeById(Integer codemp) {
        return employeDao.findEmloyeeByCodemp(codemp);

    }

    public ResponseEntity<?> SuppEmp(Integer codemp) {
        try {
            Employe employe = employeDao.findEmloyeeByCodemp(codemp);
            if (employe != null) {
                if(employe instanceof Responsable){
                    if (employeDao.existsByCodemp(employe.getCodemp())) {
                        responsableService.supprime((Responsable) employe);
                    } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsable not found");
                    }
                }
                employeDao.delete(employe);
                if (!employeDao.existsByCodemp(codemp)) {
                    return ResponseEntity.ok(getEmployees());
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problem with deletion");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
}}
