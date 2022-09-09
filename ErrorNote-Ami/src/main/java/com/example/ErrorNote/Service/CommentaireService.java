package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Repository.CommentairesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentaireService implements CommentaireInterface {

private CommentairesRepo commentairesRepo;

    private CommentairesRepo CommentairesRepo;
    @Override
    public Commentaires AjoutCommentaire(Commentaires commentaires) {

        return commentairesRepo.save(commentaires);
    }

    @Override
    public String AjoutCommentaireAutre(String contenuecomm, long idsolution,long iduser) {
        commentairesRepo.ajoutCommAutreUser(contenuecomm,idsolution,iduser);
        return "ajouter";
    }


    //Methode qui affiche tous sur Un probleme de part son id
    @Override
    public List<Commentaires> afficherTousSurUser(long idprobleme) {
        return commentairesRepo.RepoafficherTousSurUser(idprobleme);
    }
}