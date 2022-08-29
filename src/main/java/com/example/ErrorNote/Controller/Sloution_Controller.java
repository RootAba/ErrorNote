package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Service.Problemes_Interface;
import com.example.ErrorNote.Service.Solution_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "solution")
@Api(value = "hello", description = "Les fonctionnalites sur la Table Solution")
public class Sloution_Controller {
    @Autowired
    private Solution_Interface solution_interface;

    @Autowired
    private Problemes_Interface problemes_interface;
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerSolution/{idprobleme}")
    public String ajouterSolution(@RequestBody Solutions solutions, @PathVariable("idprobleme") long idprobleme){
        Problemes problemes =problemes_interface.RecupererIdProblme(idprobleme);

        if (problemes!=null){
            solutions.setProblemes(problemes);
            solutions.setDateAddSolution(new Date());
            solution_interface.CreerSolution(solutions);
        }else {
            return "";
        }
        return "Solution ajouter avec succes boss";

    }
}
