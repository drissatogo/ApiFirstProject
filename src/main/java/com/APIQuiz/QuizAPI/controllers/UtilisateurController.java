package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController {

    private IUtilisateurService utilisateurService;     //  injection

    @PostMapping("/ajouter")
    private String inscrire(@Valid @RequestBody Utilisateur utilisateur){
        utilisateurService.inscrire(utilisateur);
        return "Utilisateur ajouter";
    }

    @GetMapping("/listeAll")
    private List<Utilisateur> list(){
        return utilisateurService.listeUser();
    }

}
