package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Repository.CommentairesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class Commentaire_Implement implements Commentaire_Interface {

private CommentairesRepo commentairesRepo;
    /**
     * @param commentaires
     * @return
     */
    @Override
    public Commentaires AjoutCommentaire(Commentaires commentaires) {

        return commentairesRepo.save(commentaires);
    }

    @Override
    public String AjoutCommentaireAutre(String contenuecomm, long idsolution,long iduser) {
         commentairesRepo.ajoutCommAutreUser(contenuecomm,idsolution,iduser);
        return "ajouter";
    }


    @Override
    public List<Commentaires> afficherTousSurUser(long idsolution) {

        return commentairesRepo.RepoafficherTousSurUser(idsolution);
    }
}
