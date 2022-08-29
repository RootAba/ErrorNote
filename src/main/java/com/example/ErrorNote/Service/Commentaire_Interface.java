package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Utilisateurs;

import java.util.List;

public interface Commentaire_Interface {

    Commentaires AjoutCommentaire(Commentaires commentaires);

 String AjoutCommentaireAutre(String contenuecomm,long idsolution,long iduser);


    List<Commentaires> afficherTousSurUser(long idsolution);
}
