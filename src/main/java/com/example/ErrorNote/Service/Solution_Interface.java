package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Solutions;

import java.util.List;

public interface Solution_Interface {

    Solutions CreerSolution(Solutions solutions);

    Solutions RecupererIdSoL(Long idsolution);

    Solutions modifierSolution(Solutions solutions,long id);
    List<Solutions> verifiSi(Solutions solutions , long idprobleme);
}
