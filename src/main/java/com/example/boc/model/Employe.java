package com.example.boc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer codemp;
    @Getter
    protected String nomemp,prenemp,email,tel,password,role;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "codserv",referencedColumnName = "codserv")
    private ServiceModel service;


    @Override
    public String toString() {
        return "Employe{" +
                nomemp+prenemp+email+
                ", service=" + (service != null ? service.getNomserv() : "null") +
                '}';
    }

}
