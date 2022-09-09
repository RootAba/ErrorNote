package com.example.ErrorNote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateurs {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iduser;
    private String nom;
    private String prenom;
    private String contact;
    private String mdp;
    private String email;
    @ManyToOne
    @JoinColumn(name = "idstatut")
    private Role role;
}
