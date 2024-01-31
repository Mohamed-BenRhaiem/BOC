package com.example.boc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expediteur extends Employe{
    @ManyToMany
    @JoinTable(
            name = "courrier_expediteur_destinataire",
            joinColumns = @JoinColumn(name = "expediteur_codemp"),
            inverseJoinColumns = @JoinColumn(name = "destinataire_codemp")
    )
    private List<Destinataire> destinataires;
}
