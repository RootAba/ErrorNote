package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Service.Commentaire_Interface;
import com.example.ErrorNote.Service.Problemes_Interface;
import com.example.ErrorNote.Service.Solution_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "commentaires")
@Api(value = "hello", description = "Les fonctionnalites sur la Table Probleme")
public class Commentare_Controller {
@Autowired
private Solution_Interface solution_interface;

    @Autowired
    private Commentaire_Interface commentaire_interface;
    @ApiOperation(value = "Ajout de commentaire")
    @PostMapping("/ajoutCommentaire/{idsolution}")
    public Object ajoutCommentaire(@RequestBody Commentaires commentaires,@PathVariable("idsolution") Long idsolution){

        Solutions solutions = solution_interface.RecupererIdSoL(idsolution);

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

  /*  @ApiOperation(value = "Aff")
    @GetMapping("/AfficherActionUser/{idsolution}")
    public List<Commentaires> AfficherTousSurUser(@Param("idsolution") @PathVariable long idsolution){
        return commentaire_interface.afficherTousSurUser(idsolution);
    }*/
}
