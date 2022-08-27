package com.example.ErrorNote.Controller;


import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Service.Solution_Interface;
import com.example.ErrorNote.Service.Utilisateurs_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Utilisateurs")
@Api(value = "hello", description = "Les fonctionnalites concernant l'utilisateur")
public class Utilisateurs_Controller {

    @Autowired
    private Utilisateurs_Interface ui;
    @ApiOperation(value = "Creation de solution pour un probleme")
    @PostMapping(value = "/creerUtilisateur")
    public String ajouterUtilisateur(@RequestBody Utilisateurs utilisateurs){
       ui.ajouterUser(utilisateurs);
        return "Compte creer avec succes "+utilisateurs.getNom();
    }
}
