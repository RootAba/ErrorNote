package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Repository.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //verifier l'iden de l'user si il est admin
    @Override
    public int RechercheIduser(long iduser) {
        return ur.rechercherStatut(iduser);
    }
    @Override
    public Optional<Utilisateurs> RecupererIdUs(Long iduser) {
        return ur.findById(iduser);
    }

    @Override
    public Utilisateurs Connecter(String email, String mdp) {
        return ur.findByEmail(email);
    }
}
