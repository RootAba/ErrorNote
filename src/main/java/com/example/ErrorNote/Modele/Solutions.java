package com.example.ErrorNote.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "solutions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsolution;
    private  String desccriptionsolution,ressource,temps;

    //Many Solutions pour un probleme donnee
   /* @ManyToOne
    @JoinColumn(name = "idprobleme")
    private Problemes problemes;*/


    /*

    nous devons placer l'  annotation @JoinColumn  pour configurer
        le nom de la colonne dans la  table des utilisateurs qui correspond à la clé primaire
            dans la  table d' adresses . Si nous ne fournissons pas de nom,
                Hibernate suivra certaines règles pour en sélectionner un par défaut.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "idprobleme", referencedColumnName = "idprobleme")
    private Problemes problemes;
}
