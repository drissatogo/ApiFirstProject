package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import com.APIQuiz.QuizAPI.services.ReponseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ReponseController {


    @Autowired
    private ReponseServiceImpl reponseService;

    @GetMapping("/afficherReponse/{idReponse}")
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

    @PutMapping("/modifierReponse/{idReponse}")
    public ResponseEntity<Reponse> modifierReponse(@PathVariable Long idReponse,
                                                   @RequestParam("texte") String text,
                                                   @RequestParam("point") int point,
                                                   @RequestParam("status") String status)
    {
        Reponse reponseModifiee = reponseService.modifierReponse(idReponse, text,point,status);
        if (reponseModifiee != null) {
            return ResponseEntity.ok(reponseModifiee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/modifierUnElementReponse/{idReponse}")
    public ResponseEntity<Reponse> modifierUnElementReponse(@PathVariable Long idReponse, @RequestBody Reponse reponse) {
        Reponse reponseModifiee = reponseService.modifierUnElemntReponse(idReponse, reponse);
        return ResponseEntity.ok(reponseModifiee);
    }



    @DeleteMapping("/supprimerReponse/{idReponse}")
    public ResponseEntity<Void> supprimerReponse(@PathVariable Long idReponse) {
        reponseService.supprimerReponse(idReponse);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/afficherListeReponses")
    public ResponseEntity<List<Reponse>> afficherListeReponses() {
        List<Reponse> reponses = reponseService.afficherLesReponses();
        return ResponseEntity.ok(reponses);
    }
}
