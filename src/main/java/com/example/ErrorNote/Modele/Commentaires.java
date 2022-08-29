package com.example.ErrorNote.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "commentaires")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commentaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idcom;
    private String contenuecomm;

    //plusieurs comm peuvent etre faite sur une solution
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idsolution")
    private Solutions solutions;

    @ManyToOne
    @JoinColumn(name = "idautreuser")
    private Utilisateurs utilisateurs;
}
