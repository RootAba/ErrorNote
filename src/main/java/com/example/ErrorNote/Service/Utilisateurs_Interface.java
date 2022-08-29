package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;

import java.util.Optional;

public interface Utilisateurs_Interface {

    Utilisateurs ajouterUser(Utilisateurs utilisateurs);

    Utilisateurs RecupererIdUser(Long iduser);

    String SupprimerUser(long iduser);

    int RechercheIduser(long idstatut);

    Optional<Utilisateurs> RecupererIdUs(Long iduser);
}
