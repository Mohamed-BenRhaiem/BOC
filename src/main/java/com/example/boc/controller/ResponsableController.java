package com.example.boc.controller;


import com.example.boc.model.LoginRequest;
import com.example.boc.model.Responsable;
import com.example.boc.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")

public class ResponsableController {
    @Autowired
    ResponsableService responsableService;
    @PostMapping("createResponsable")
    public ResponseEntity<String> createResponsable(@RequestBody Responsable responsable){
        try{
            if(responsableService.RespExist(responsable.getEmail()))
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("email déja registré");

            if(responsableService.serviceHasResponsable(responsable.getService()))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ce service a déja un responsable");

            responsable.setRespserv(responsable.getService());
            responsableService.createResponsable(responsable);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Responsable ajouté avec succés");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }



    @PostMapping("loginPage")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        if(!responsableService.validateResponsable(loginRequest.getMail(), loginRequest.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Pas de responseable avec ce compte");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("accepted login");
    }

}