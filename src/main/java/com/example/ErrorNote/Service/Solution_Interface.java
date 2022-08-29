package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Solutions;

public interface Solution_Interface {

    Solutions CreerSolution(Solutions solutions);

    Solutions RecupererIdSoL(Long idsolution);
}
