package com.example.boc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codsoc;

    private String nomsoc;

    @OneToMany
    @JsonIgnore
    private List<ServiceModel> services;
    @JsonIgnore
    @OneToMany
    private List<Direction> directions;

}
