package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private IUtilisateurService utilisateurService;     //  injection

//    endpoint: Inscrire Utilisateur
    @PostMapping("/ajouter")
    private Utilisateur inscrire(@Valid @RequestBody Utilisateur utilisateur){
          return utilisateurService.inscrire(utilisateur);
    }

//    endpoint: connecter Utilisateur
        @GetMapping("/connecter")
        private String connecter(@RequestParam String username, @RequestParam String password){
            utilisateurService.connexion(username,password);
           return "Connexion reussit";

    }

//    endpoint: afficher toute la liste de Utilisateur
    @GetMapping("/listeAll")
    private List<Utilisateur> list(){
        return utilisateurService.afficher();
    }

//    enpoint: lire un Utilisateur
    @GetMapping("/listeId")
    private Utilisateur userAllList(@RequestParam Long idUser) {
           return utilisateurService.lire(idUser);
    }

//    enpoint: modifier Utilisateur
    @PutMapping("/modifierUser")
    private Utilisateur modifier(@Valid @RequestBody Utilisateur user){
        return utilisateurService.modifier(user);
    }

//    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerUser")
    private String supprimer(@Valid @RequestParam Long idUser){
        utilisateurService.supprimer(idUser);
        return "User supprimer avec succes";
    }
}
