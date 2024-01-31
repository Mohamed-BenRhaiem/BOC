package com.example.boc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "employes")
public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codserv;
    private String nomserv;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Employe> employes = new HashSet<>();
    @JsonIgnore
    @OneToOne(mappedBy = "respserv")
    private Responsable respserv;

    public void addEmploye(Employe emp){
        employes.add(emp);
    }



}
