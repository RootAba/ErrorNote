package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Statut;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Service.Statut_Interface;
import com.example.ErrorNote.Service.Utilisateurs_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "Utilisateurs")
@Api(value = "hello", description = "Les fonctionnalites concernant l'utilisateur")
public class Utilisateurs_Controller {

    @Autowired
    private Utilisateurs_Interface ui;
    @Autowired
    private Statut_Interface si;
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
        if (statut!=null && statut.getStatut().equals("Admin")){
            return  ui.SupprimerUser(iduser);
        }
       else{
           return  "Vous n'avez pas le droit de supprimer";
       }

    }
}
