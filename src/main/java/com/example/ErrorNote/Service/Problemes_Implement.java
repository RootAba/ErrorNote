package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Repository.ProblemesRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class Problemes_Implement implements  Problemes_Interface{

    private  ProblemesRepo pr;

    @Override
    public Problemes CreerProbleme(Problemes problemes) {

        return pr.save(problemes);
    }

    @Override
    public List<Problemes> Rechercher(String titre) {

        return pr.Rechercher(titre);
    }
}
