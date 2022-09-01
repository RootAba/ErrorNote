package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Statut;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Service.Problemes_Interface;
import com.example.ErrorNote.Service.Statut_Interface;
import com.example.ErrorNote.Service.Utilisateurs_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "Utilisateurs")
@Api(value = "hello", description = "Les fonctionnalites concernant l'utilisateur")
public class Utilisateurs_Controller {

    @Autowired
    private Utilisateurs_Interface ui;
    @Autowired
    private Statut_Interface si;

    @Autowired
    private Problemes_Interface problemes_interface;
    @ApiOperation(value = "Creation user")
    @PostMapping(value = "/creerUtilisateur/{idstatut}")
    public String ajouterUtilisateur(@RequestBody Utilisateurs utilisateurs,@PathVariable("idstatut") long idstatut){
//essai de verificationde statu

Statut statut =si.RecupererIdStatut(idstatut);
if(statut!=null){
    utilisateurs.setStatut(statut);
    ui.ajouterUser(utilisateurs);
}

        return "Compte creer avec succes "+utilisateurs.getNom();
    }


    //Supprimer utilisateur par l'administrateur

    @ApiOperation(value = "Supprimer user")
    @DeleteMapping(value = "supprimer/{iduser}/{idstatut}")
  public  String SupprimerUser(Utilisateurs utilisateurs, @Param("iduser") @PathVariable("iduser") long iduser,@Param("idstatut") @PathVariable("idstatut") long idstatut){
        Statut statut = si.RecupererIdStatut(idstatut);
        if (statut!=null && statut.getStatut().equals("ADMIN")){
            return  ui.SupprimerUser(iduser);
        }
       else{
           return  "Vous n'avez pas le droit de supprimer";
       }

    }

    //===========Fonction permettant de creer un probleme apres authentification==============

    @ApiOperation(value = "Connection")
    @PostMapping(value = "supprimer/{iduser}/{email}/{mdp}")
    public String Authen(@RequestBody Problemes problemes, @Param("email") @PathVariable("email") String email, @PathVariable("mdp") String mdp){
        Utilisateurs utilisateurs = ui.Connecter(email,mdp);
        if(utilisateurs !=null && utilisateurs.getMdp().equals(mdp)){
//==========Creation de probleme=================
            utilisateurs.getIduser();
            problemes.setUtilisateurs(utilisateurs);
            problemes.setDateaddpro(new Date());
            problemes_interface.CreerProbleme(problemes);
           // return "cool";
          //  return    utilisateurs.getIduser();
        }
        return  "erreur";
    }
}
