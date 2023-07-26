package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import com.APIQuiz.QuizAPI.services.ReponseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class ReponseController {


    private ReponseServiceImpl reponseService;

    @GetMapping("/{id}")
    public ResponseEntity<Reponse> getReponseById(@PathVariable Long idReponse) {
        Reponse reponse = reponseService.getReponseById(idReponse);
        if (reponse != null) {
            return ResponseEntity.ok(reponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creerReponse")
    public ResponseEntity<Reponse> creerReponse(@RequestBody Reponse reponse) {
        Reponse nouvelleReponse = reponseService.creerReponse(reponse);
        return ResponseEntity.ok(nouvelleReponse);
    }

    @PutMapping("/modifierReponse")
    public ResponseEntity<Reponse> modifierReponse(@PathVariable Long idReponse, @RequestParam String text) {
        Reponse reponseModifiee = reponseService.modifierReponse(idReponse, text);
        if (reponseModifiee != null) {
            return ResponseEntity.ok(reponseModifiee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supprimerReponse")
    public ResponseEntity<Void> supprimerReponse(@PathVariable Long idReponse) {
        reponseService.supprimerReponse(idReponse);
        return ResponseEntity.noContent().build();
    }
}
