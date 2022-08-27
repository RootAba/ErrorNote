package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Repository.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class Utilisateurs_Implement implements  Utilisateurs_Interface{
   private UtilisateurRepo ur;
    /**
     * @param utilisateurs
     * @return
     */
    @Override
    public Utilisateurs ajouterUser(Utilisateurs utilisateurs) {
        return ur.save(utilisateurs);
    }
}
