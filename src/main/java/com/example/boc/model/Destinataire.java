package com.example.boc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Destinataire extends Employe{
    @ManyToMany(mappedBy = "destinataires")
    private List<Expediteur>expediteurs;
}
