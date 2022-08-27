package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Service.Commentaire_Interface;
import com.example.ErrorNote.Service.Problemes_Interface;
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
    private Commentaire_Interface commentaire_interface;
    @ApiOperation(value = "Ajout de commentaire")
    @PostMapping("/ajoutCommentaire")
    public Commentaires ajoutCommentaire(@RequestBody Commentaires commentaires){
        return commentaire_interface.AjoutCommentaire(commentaires);
    }

    // Ajout commentaire des autre user
    @ApiOperation(value = "Ajout de commentaire")
    @PostMapping("/ajoutCommentaire/{idsolution}/{contenuecomm}/{iduser}")
   // @PostMapping("/essai/{idd}")

    public String AjoutCommentaireAutreUser(@Param("idsolution") @PathVariable long idsolution,@Param("contenuecomm") @PathVariable String contenuecomm ,@Param("iduser") @PathVariable long iduser){

        return commentaire_interface.AjoutCommentaireAutre(contenuecomm,idsolution,iduser);
    }

  /*  @ApiOperation(value = "Aff")
    @GetMapping("/AfficherActionUser/{idsolution}")
    public List<Commentaires> AfficherTousSurUser(@Param("idsolution") @PathVariable long idsolution){
        return commentaire_interface.afficherTousSurUser(idsolution);
    }*/
}
