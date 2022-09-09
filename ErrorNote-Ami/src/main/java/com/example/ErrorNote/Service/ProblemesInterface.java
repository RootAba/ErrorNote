package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Problemes;

import java.util.List;


public interface ProblemesInterface {

    Problemes CreerProbleme(Problemes problemes);

    List<Problemes> Rechercher(String titre);

    Problemes RecupererIdProblme(Long idprobleme);

    Problemes modifierStatut(Long idprobleme, Problemes problemes);

    //supp blem
    List<Problemes> SuppPro(Long iduser);
}
