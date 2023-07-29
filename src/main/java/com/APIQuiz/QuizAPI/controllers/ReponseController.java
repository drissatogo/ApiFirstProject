package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import com.APIQuiz.QuizAPI.services.ReponseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class ReponseController {


    @Autowired
    private ReponseServiceImpl reponseService;

    @GetMapping("/afficherReponse/{idReponse}")
    @Operation(summary = "Liste de réponse par son identfiant")
    @ApiResponse(responseCode = "200", description = "Reponse trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Reponse non trouvée")

    public ResponseEntity<Reponse> getReponseById(@PathVariable Long idReponse) {
        Reponse reponse = reponseService.getReponseById(idReponse);
        if (reponse != null) {
            return ResponseEntity.ok(reponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creerReponse")
    @Operation(summary = "Création de reponse par l'utilisateur")
    @ApiResponse(responseCode = "200", description = "Réponse crée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Réponse non crée")

    public ResponseEntity<Reponse> creerReponse(@RequestBody Reponse reponse) {
        Reponse nouvelleReponse = reponseService.creerReponse(reponse);
        return ResponseEntity.ok(nouvelleReponse);
    }

    @PutMapping("/modifierReponse/{idReponse}")
    @Operation(summary = "Modifier une reponse par son identifiant")
    @ApiResponse(responseCode = "200", description = "Réponse modifier avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Réponse non modifiée")

    public ResponseEntity<Reponse> modifierReponse(@PathVariable Long idReponse, @RequestParam("text") String text) {
        Reponse reponseModifiee = reponseService.modifierReponse(idReponse, text);
        if (reponseModifiee != null) {
            return ResponseEntity.ok(reponseModifiee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supprimerReponse/{idReponse}")
    @Operation(summary = "Suppression de reponse par son identifiant")
    @ApiResponse(responseCode = "200", description = "Réponse supprimée avec succès",
            content = @Content(schema = @Schema(implementation = Reponse.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")

    public ResponseEntity<Void> supprimerReponse(@PathVariable Long idReponse) {
        reponseService.supprimerReponse(idReponse);
        return ResponseEntity.noContent().build();
    }
}
