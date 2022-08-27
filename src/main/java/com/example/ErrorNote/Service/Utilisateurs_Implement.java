package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Repository.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class Utilisateurs_Implement implements  Utilisateurs_Interface{
    @Autowired
   private UtilisateurRepo ur;
    /**
     * @param utilisateurs
     * @return
     */
    @Override
    public Utilisateurs ajouterUser(Utilisateurs utilisateurs) {
        return ur.save(utilisateurs);
    }

    @Override
    public Utilisateurs RecupererIdUser(Long iduser) {
        return ur.findById(iduser).get();
    }

    @Override
    public String SupprimerUser(long iduser) {
        ur.deleteById(iduser);
        return "Supprimer avec succes";
    }

    @Override
    public int RechercheIduser(long idstatut) {
        return ur.rechercherStatut(idstatut);
    }
}
