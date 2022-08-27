package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Service.Solution_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "solution")
@Api(value = "hello", description = "Les fonctionnalites sur la Table Solution")
public class Sloution_Controller {
    @Autowired
    private Solution_Interface solution_interface;
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerSolution")
    public String ajouterSolution(@RequestBody Solutions solutions){
        solution_interface.CreerSolution(solutions);
        return "Solution ajouter avec succes boss";
    }
}
