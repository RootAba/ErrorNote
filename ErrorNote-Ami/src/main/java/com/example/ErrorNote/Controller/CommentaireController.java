package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Service.CommentaireInterface;
import com.example.ErrorNote.Service.SolutionInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "commentaires")
@Api(value = "hello", description = "Les Commentaires")
public class CommentaireController {
    @Autowired
    private SolutionInterface SolutionInterface;

    @Autowired
    private CommentaireInterface commentaire_interface;

    @Autowired
    private  SolutionInterface SI;
    @ApiOperation(value = "Ajout de commentaire")
    @PostMapping("/ajoutCommentaire/{idsolution}")
    public Object ajoutCommentaire(@RequestBody Commentaires commentaires,@PathVariable("idsolution") Long idsolution){

        Solutions solutions = SolutionInterface.RecupererIdSoL(idsolution);

        if (solutions!=null){
            commentaires.setSolutions(solutions);
            return commentaire_interface.AjoutCommentaire(commentaires);
        }
        return "Commentaire ajouté avec succes";
    }

    // Ajout commentaire des autre user
    @ApiOperation(value = "Ajout de commentaire")
    @PostMapping("/ajoutCommentaire/{idsolution}/{contenuecomm}/{iduser}")
    public String AjoutCommentaireAutreUser(@Param("idsolution") @PathVariable long idsolution,@Param("contenuecomm") @PathVariable String contenuecomm ,@Param("iduser") @PathVariable long iduser){

        return commentaire_interface.AjoutCommentaireAutre(contenuecomm,idsolution,iduser);
    }

    @ApiOperation(value = "Aff")
    @GetMapping("/AfficherActionUser/{idsolution}")
    public List<Commentaires> AfficherTousSurUser(@Param("idsolution") @PathVariable long idsolution){
        Solutions solution = SI.RecupererIdSoL(idsolution);
        return solution.getCommentairesList();
        //return commentaire_interface.afficherTousSurUser(idsolution);
    }

    @ApiOperation(value = "Affi")
    @GetMapping("/AfficherActionUser/{idprobleme}")
    public List<Commentaires> AfficherTousUser(@Param("idprobleme") @PathVariable long idprobleme){

        return commentaire_interface.afficherTousSurUser(idprobleme);

    }
}
