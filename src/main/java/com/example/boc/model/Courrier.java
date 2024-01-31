package com.example.boc.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Courrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @Enumerated(EnumType.STRING)
    private TypeCourrier typeCourrier;
    private Date date,dateDoc;
    private Long refDoc;
    private String object;
    private Long image;

    @ManyToOne
    @JoinTable(
            name = "courrier_expediteur_destinataire",
            joinColumns = @JoinColumn(name = "num_courrier"),
            inverseJoinColumns = {
                    @JoinColumn(name = "expediteur_codemp"),
            }
    )
    private Expediteur expediteur;

    @ManyToOne
    private Destinataire destinataire;

}
