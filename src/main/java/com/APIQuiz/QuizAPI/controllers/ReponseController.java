package com.APIQuiz.QuizAPI.controllers;
import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import com.APIQuiz.QuizAPI.services.ReponseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.services.IReponseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class ReponseController {


    @Autowired
    private ReponseServiceImpl reponseService;

    @GetMapping("/afficherReponse/{idReponse}")
    public ResponseEntity<Reponse> afficher(@PathVariable Long idReponse) {
        Reponse reponse = reponseService.afficher(idReponse);
        if (reponse != null) {
            return ResponseEntity.ok(reponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ajouter")
    private String ajouter(@Valid @RequestBody Reponse reponse){
        reponseService.ajouter(reponse);
        return "Quiz a ete cree";
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
        reponseService.supprimer(idReponse);
        return ResponseEntity.noContent().build();
    }

   /* @GetMapping("/afficherListeReponses")
    public ResponseEntity<List<Reponse>> afficherListeReponses() {
        List<Reponse> reponses = reponseService.afficherLesReponses();
        return ResponseEntity.ok(reponses);
    }*/
/*@RestController
@AllArgsConstructor
@RequestMapping("reponse")
public class ReponseController {

    private IReponseService reponseService;

    //    endpoint: ajouter reponse
    @PostMapping("/ajouter")
    private String ajouter(@Valid @RequestBody Reponse reponse){
        reponseService.ajouter(reponse);
        return "Quiz a ete cree";
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllQuiz")
    private List<Reponse> list(){
        return reponseService.afficher();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdQuiz")
    private Reponse lire(@RequestParam Long idReponse){
        return reponseService.lire(idReponse);
    }

    //    enpoint: modifier reponse
    @PutMapping("/modifier")
    private String modifier(@Valid @RequestBody Reponse reponse){
        reponseService.modifier(reponse);
        return "Reponse modifier";
    }

    //    endpoint: supprimer reponse
    @DeleteMapping("/supprimer")
    private String supprimer(@RequestParam Long idReponse){
        reponseService.supprimer(idReponse);
        return "Quiz supprimer avec succes";
    }

}}*/}
