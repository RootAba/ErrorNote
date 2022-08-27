package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Utilisateurs;

public interface Utilisateurs_Interface {

    Utilisateurs ajouterUser(Utilisateurs utilisateurs);

    Utilisateurs RecupererIdUser(Long iduser);

    String SupprimerUser(long iduser);

    int RechercheIduser(long idstatut);
}
