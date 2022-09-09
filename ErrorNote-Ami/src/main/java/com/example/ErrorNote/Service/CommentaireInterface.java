package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;

import java.util.List;

public interface CommentaireInterface {

    Commentaires AjoutCommentaire(Commentaires commentaires);

    String AjoutCommentaireAutre(String contenuecomm,long idsolution,long iduser);


    //List<Commentaires> afficherTousSurUser(long idsolution);

    List<Commentaires> afficherTousSurUser(long idprobleme);
}
