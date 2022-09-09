package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;

import java.util.Optional;

public interface UtilisateursInterface {

    Utilisateurs ajouterUser(Utilisateurs utilisateurs);

    Utilisateurs RecupererIdUser(Long iduser);

    String SupprimerUser(long iduser);

    int RechercheIduser(long idstatut);

    Optional<Utilisateurs> RecupererIdUs(Long iduser);

    //Fonction ajouter
    Utilisateurs Connecter(String email,String mdp);
}
