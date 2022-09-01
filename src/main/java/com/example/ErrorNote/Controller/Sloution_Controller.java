package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Service.Problemes_Interface;
import com.example.ErrorNote.Service.Solution_Interface;
import com.example.ErrorNote.Service.Utilisateurs_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "solution")
@Api(value = "hello", description = "Les fonctionnalites sur la Table Solution")
public class Sloution_Controller {
    @Autowired
    private Solution_Interface solution_interface;
@Autowired
private Utilisateurs_Interface ui;
    @Autowired
    private Problemes_Interface problemes_interface;
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerSolution/{idprobleme}/{email}/{mdp}")
    public String ajouterSolution(@RequestBody Solutions solutions, @PathVariable("idprobleme") long idprobleme, @Param("email") @PathVariable("email") String email, @PathVariable("mdp") String mdp){
      //verifcation de l'utilisateur
        Utilisateurs utilisateurs = ui.Connecter(email,mdp);
        //recuperation du probleme
        Problemes problemes =problemes_interface.RecupererIdProblme(idprobleme);
        if(utilisateurs !=null && utilisateurs.getMdp().equals(mdp)){
                 if(problemes!=null && utilisateurs.getIduser() == problemes.getUtilisateurs().getIduser()){
                    solutions.setProblemes(problemes);
                    solutions.setDateAddSolution(new Date());
                    solution_interface.CreerSolution(solutions);
                }
                else {
                    return "Vous ne pouvez pas donner de solution à ce probleme desolée";
                }
        }
        else {
            return "Desolée veuillez verifier votre email ou mot de passe";
        }

        return "Solution ajouter avec succes boss";

    }
/*
    @ApiOperation(value = "modifier de solution pour un probleme")
    @PutMapping(value = "/modifSolution/{idprobleme}/{email}/{mdp}")
    public String ModifierSolution(@RequestBody Solutions solutions, @PathVariable("idprobleme") long idprobleme, @Param("email") @PathVariable("email") String email, @PathVariable("mdp") String mdp) {
        Utilisateurs utilisateurs = ui.Connecter(email, mdp);
        Problemes problemes = problemes_interface.RecupererIdProblme(idprobleme);
        Solutions solutions1 = (Solutions) solution_interface.verifiSi(solutions,idprobleme);
        if (solutions1!=null){
            long idsol= solutions1.getIdsolution();
            solutions.setIdsolution(solutions1.getIdsolution());
            if(solutions.getProblemes().getIdprobleme()==problemes.getIdprobleme() && problemes.getUtilisateurs().getIduser()==utilisateurs.getIduser())  {
              //  long idsol=solutions.getIdsolution();
                solution_interface.modifierSolution(solutions,idsol);
            }
        }


return "succes";
    }*/

}
