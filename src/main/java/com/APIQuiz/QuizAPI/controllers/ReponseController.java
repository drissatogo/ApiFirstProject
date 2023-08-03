package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.APIQuiz.QuizAPI.entites.Reponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    private IReponseService reponseService;

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
=======
>>>>>>> 436a9e88d413890c4a716e8f0ecd0510d5c77aca
@AllArgsConstructor
@RequestMapping("reponse")
public class ReponseController {

    private IReponseService reponseService;

    //    endpoint: ajouter reponse
    @PostMapping("/ajouter")
    @Operation(summary = "Création de reponse par l'utilisateur")
    @ApiResponse(responseCode = "200", description = "Réponse crée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Réponse non crée")
    private String ajouter(@Valid @RequestBody Reponse reponse){
        reponseService.ajouter(reponse);
        return "La réponse a été crée";
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllQuiz")
    @Operation(summary = "Afficher toute la liste de tout les quiz")
    @ApiResponse(responseCode = "200", description = "La liste des quiz a été trouvé",
            content = @Content(schema = @Schema(implementation = Quiz.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")
    private List<Reponse> list(){
        return reponseService.afficher();
    }
    //    enpoint: afficher liste par id
    @GetMapping("/listeIdQuiz")
    @Operation(summary = "Liste de réponse par son identfiant")
    @ApiResponse(responseCode = "200", description = "Reponse trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Reponse non trouvée")
    private Reponse lire(@RequestParam Long idReponse){
        return reponseService.lire(idReponse);
    }

    //    enpoint: modifier reponse
    @PutMapping("/modifier")
    @Operation(summary = "Modifier une reponse")
    @ApiResponse(responseCode = "200", description = "Réponse modifier avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Réponse non modifiée")
    private String modifier(@Valid @RequestBody Reponse reponse){
        reponseService.modifier(reponse);
        return "Réponse modifiée";
    }

    //    endpoint: supprimer reponse
    @DeleteMapping("/supprimer")
    @Operation(summary = "Suppression de reponse par son identifiant")
    @ApiResponse(responseCode = "200", description = "Réponse supprimée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")
    private String supprimer(@RequestParam Long idReponse){
        reponseService.supprimer(idReponse);
        return "Quiz supprimer avec succes";
    }
<<<<<<< HEAD

}}*/}

