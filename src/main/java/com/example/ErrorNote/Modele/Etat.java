package com.example.ErrorNote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "etat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idetat;
    private String typeEtat;
}
