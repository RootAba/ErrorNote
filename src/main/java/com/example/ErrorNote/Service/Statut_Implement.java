package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Statut;
import com.example.ErrorNote.Repository.StatutRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Statut_Implement implements  Statut_Interface{
    @Autowired
    private StatutRepo statutRepo;
    @Override
    public Statut RecupererIdStatut(Long idstatut) {
        return statutRepo.findByIdstatut(idstatut);
    }
}
