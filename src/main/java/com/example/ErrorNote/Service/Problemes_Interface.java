package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Repository.ProblemesRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Problemes_Interface {

    Problemes CreerProbleme(Problemes problemes);

    List<Problemes> Rechercher(String titre);
}
