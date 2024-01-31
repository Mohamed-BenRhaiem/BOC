package com.example.boc.service;

import com.example.boc.Dao.ResponsableDao;
import com.example.boc.Dao.ServiceDao;
import com.example.boc.model.Employe;
import com.example.boc.model.ServiceModel;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service

public class ServiceService {
    @Autowired
    ServiceDao serviceDao;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ResponsableDao responsableDao;

    public List<ServiceModel> getAllServices(){
        return serviceDao.findAll();
    }

    public void addService( ServiceModel service) {
        serviceDao.save(service);
    }

    public void addServiceAndAssociateWithEmployee(ServiceModel service, Employe emp) {
        // Set the service for the employee
        emp.setService(service);

        // Save the employee
        employeeService.addEmployee(emp);

        service.addEmploye(emp);
        serviceDao.save(service);
    }


    public ServiceModel getServiceById(Integer codserv) {
        return serviceDao.findByCodserv(codserv);
    }


}
