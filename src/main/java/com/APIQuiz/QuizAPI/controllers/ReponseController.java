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
import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.services.IReponseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
