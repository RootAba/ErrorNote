package com.example.ErrorNote.Modele;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idstatut;
    private String statut;
}
