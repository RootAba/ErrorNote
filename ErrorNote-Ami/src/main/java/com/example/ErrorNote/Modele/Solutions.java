package com.example.ErrorNote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private  String desccriptionsolution,ressource;
    private Date dateAddSolution;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idprobleme", referencedColumnName = "idprobleme")
    private Problemes problemes;

    @OneToMany(mappedBy = "solutions")
    List<Commentaires> commentairesList = new ArrayList<>();


}
