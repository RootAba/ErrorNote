package com.example.ErrorNote.Controller;

import com.example.ErrorNote.Modele.Problemes;
import com.example.ErrorNote.Modele.Utilisateurs;
import com.example.ErrorNote.Repository.ProblemesRepo;
import com.example.ErrorNote.Repository.UtilisateurRepo;
import com.example.ErrorNote.Service.Problemes_Interface;
import com.example.ErrorNote.Service.Utilisateurs_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "CreerProbleme")
@NoArgsConstructor
@AllArgsConstructor

@Api(value = "hello", description = "Les fonctionnalites sur la Table Probleme")
public class Problemes_Controller {
    @Autowired
    private Problemes_Interface problemes_interface;
    @Autowired
    private Utilisateurs_Interface utilisateurs_interface;
    @ApiOperation(value = "Creation de probleme")
    @PostMapping("/problemes/{iduser}")
    public Object CreerProbleme(@RequestBody Problemes problemes, @PathVariable("iduser") Long iduser){
        Utilisateurs utilisateurs = utilisateurs_interface.RecupererIdUser(iduser);

        if (utilisateurs!=null){
            problemes.setUtilisateurs(utilisateurs);
            problemes_interface.CreerProbleme(problemes);
        }else {
            return "";
        }
       return "";
    }

    @ApiOperation(value = "Recherche de probleme avec le titre ")
    @GetMapping("/problemes/{titre}")
    public  List<Problemes> RechercherProbleme(@Param("titre") @PathVariable String titre){

        return problemes_interface.Rechercher(titre);
    }

}
