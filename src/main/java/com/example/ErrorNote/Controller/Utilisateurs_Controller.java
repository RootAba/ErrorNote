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
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerUtilisateur/{idstatut}")
    public String ajouterUtilisateur(@RequestBody Utilisateurs utilisateurs, @PathVariable("idstatut") long idstatut){
        Statut statut = si.RecupererIdStatut(idstatut);

        if (statut!=null){

            utilisateurs.setStatut(statut);
            ui.ajouterUser(utilisateurs);
        }else {
            return "Statut est vide";
        }



        return "Compte creer avec succes "+utilisateurs.getNom();
    }

    @ApiOperation(value = "Supprimer user")
    @DeleteMapping(value = "supprimer/{iduser}/{idstatut}")
  public  String SupprimerUser(Utilisateurs utilisateurs, @Param("iduser") @PathVariable("iduser") long iduser,@Param("idstatut") @PathVariable("idstatut") long idstatut){
//long x=utilisateurs.getStatut().getIdstatut();
      int x = ui.RechercheIduser(idstatut);
       if(x == 1){
           return  ui.SupprimerUser(iduser);
       }
       else{
           return  "errer";
       }
        /*
        if(utilisateurs==1){
            return  ui.SupprimerUser(iduser);
        }*/


    }
}
