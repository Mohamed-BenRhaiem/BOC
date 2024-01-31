package com.example.boc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Direction  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coddir;
    private String nomdir;
    @OneToOne
    @JoinColumn(name = "codrespdir")
    @JsonIgnore
    private Employe respdir;
}
