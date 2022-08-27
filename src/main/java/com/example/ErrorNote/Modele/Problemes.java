package com.example.ErrorNote.Modele;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "problemes")
@NoArgsConstructor
@Getter
@Setter
public class Problemes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idprobleme;
    private String titre, description,techno;

    //Un probleme peut etre creer par un seul user
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "iduser")
    private Utilisateurs utilisateurs;

    // un etat donnee peut concerner plusieurs probles
    @ManyToOne
    @JoinColumn(name = "idetat")
    private Etat etat;


    /*
    l' attribut mappedBy est utilisé pour définir le côté référençant
    (côté non propriétaire) de la relation.
     */
  /*  @OneToOne(mappedBy = "problemes")
    private Solutions solutions;*/
}
