package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController {

    private IUtilisateurService utilisateurService;     //  injection

//    endpoint: Inscrire Utilisateur
    @PostMapping("/ajouter")
    private String inscrire(@Valid @RequestBody Utilisateur utilisateur){
        if (utilisateur!=null){
            utilisateurService.inscrire(utilisateur);
            return "Utilisateur ajouter";
        }else {
            return "Remplisser les champs vide";
        }
    }

//    endpoint: connecter Utilisateur
        @GetMapping("/connecter")
        private String connecter(@RequestParam String username, @RequestParam String password){
        if (username!=null && password!=null){
           return utilisateurService.connexion(username,password)+"";
        }else {
            return "Remplisser les champs vides";
        }
    }

//    endpoint: afficher toute la liste
    @GetMapping("/listeAll")
    private List<Utilisateur> list(){
        return utilisateurService.listeUser();
    }

//    enpoint: afficher liste par id
    @GetMapping("/listeId")
    private ResponseEntity<Utilisateur> userAllList(@Valid @RequestParam Long idUser){
        if (idUser==null) throw new RuntimeException("Remplissez les champs vite");
        Utilisateur user = utilisateurService.afficherParId(idUser);
        return ResponseEntity.ok(user);
    }

//    enpoint: modifier Utilisateur
    @PutMapping("/modifierUser")
    private Utilisateur modifier(@Valid @RequestBody Utilisateur user){
        if (user==null) throw new RuntimeException("Remplissez les champs vite");
        return utilisateurService.modifier(user);
    }

//    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerUser")
    private String supprimer(@Valid @RequestParam Long idUser){
        if (idUser==null) throw new RuntimeException("Choisissez un user");
        utilisateurService.supprimer(idUser);
        return "User supprimer avec succes";
    }


}
