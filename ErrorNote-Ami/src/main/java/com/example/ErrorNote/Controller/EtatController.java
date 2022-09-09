package com.example.ErrorNote.Controller;

import com.example.ErrorNote.Modele.Etat;
import com.example.ErrorNote.Service.EtatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Etat")
@Api(value = "hello", description = "Les Etats")
public class EtatController {
    @Autowired
    private EtatService Etat_Implement;

    @ApiOperation(value = "Creation des Etats pour des problèmes")
    @PostMapping(value = "/creerEtat")
    public String AjouterEtat(@RequestBody Etat etat){
        Etat_Implement.AjouterEtat(etat);
        return "Etat créé avec succes "+etat.getTypeEtat();
    }

}
