package com.example.boc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Responsable extends Employe{
    @OneToOne
    @JoinColumn(name = "codserv", referencedColumnName = "codserv")
    @JsonIgnore
    private ServiceModel respserv;



}
