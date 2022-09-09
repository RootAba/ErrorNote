package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Etat;
import com.example.ErrorNote.Repository.EtatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EtatService implements EtatInterface {

    private final EtatRepo EtatRepo;

    @Override
    public Etat AjouterEtat(Etat etat) {
        return EtatRepo.save(etat);
    }



}
