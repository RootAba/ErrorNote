package com.example.ErrorNote.Modele;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "problemes")
@NoArgsConstructor
@Getter
@Setter
public class Problemes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idprobleme;
    private String titre, description;
    private Date dateaddpro;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private Utilisateurs utilisateurs;

    @ManyToOne
    @JoinColumn(name = "idetat")
    private Etat etat;


}
