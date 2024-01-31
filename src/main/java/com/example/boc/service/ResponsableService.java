package com.example.boc.service;

import com.example.boc.Dao.EmployeDao;
import com.example.boc.Dao.ResponsableDao;
import com.example.boc.model.Employe;
import com.example.boc.model.Responsable;
import com.example.boc.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsableService {
    @Autowired
    private ResponsableDao responsableDao;
    @Autowired
    private EmployeDao employeDao;


    public void createResponsable(Responsable responsable){
        responsable.setPassword(new BCryptPasswordEncoder().encode(responsable.getPassword()));
        responsableDao.save(responsable);
    }

    public boolean RespExist(String email) {
        Employe employe = employeDao.findByEmail(email);
        return employe!=null;
    }

    public boolean serviceHasResponsable(ServiceModel service) {
        Responsable responsable = responsableDao.findByService(service);
        return responsable!=null;
    }

    public boolean validateResponsable(String email, String password) {
        Optional<Employe> userOptional = Optional.ofNullable(employeDao.findByEmail(email));

        if (userOptional.isPresent()) {
            Employe user = userOptional.get();

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.matches(password,user.getPassword());

        }

        return false;
    }


    public String generateToken(Responsable responsable){
        return "";
    }

    public ResponseEntity<String > supprime(Responsable responsable) {
        responsableDao.delete(responsable.getCodemp());
        if(!this.RespExist(responsable.getEmail()))
            return ResponseEntity.ok("responsable supprimee");

        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("responsable trouvé");
    }
}
