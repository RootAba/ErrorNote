package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Service.SolutionService;
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
public class SolutionController {
    @Autowired
    private SolutionService SolutionService;
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerSolution")
    public String ajouterSolution(@RequestBody Solutions solutions){
        SolutionService.CreerSolution(solutions);
        return "Solution ajouter ";
    }
}
