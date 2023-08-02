package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IParticipationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/participation")
@AllArgsConstructor
public class ParticipationController {

    private IParticipationService participationService;


    //================================= End-Point: Ajouter des participants ===========================
    @PostMapping("/ajouterPart")
    @Operation(summary = "Ajout des participants")
    @ApiResponse(responseCode = "200", description = "Participant ajouté avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Participant non ajouté")

    private String ajouter(@Valid @RequestBody Participation participation) {
        participationService.ajouter(participation);
        return "Participant ajouter";
    }

    //================================= End-Point: Liste de tous les participants ===========================
    @GetMapping("/listeAllParticipant")
    @Operation(summary = "Liste de tous les participants")
    @ApiResponse(responseCode = "200", description = "Liste trouvé avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")
    private List<Participation> list(){
        return participationService.afficher();
    }

    //================================= End-Point: Liste des participants par leurs identifiants ===========================
    @GetMapping("/listeIdPart")
    @Operation(summary = "Liste des participants par leur identifiant")
    @ApiResponse(responseCode = "200", description = "Liste trouvée",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")
    private Participation quizIdListe(@RequestParam Long idPart){
        return participationService.lire(idPart);
    }

    //================================= End-Point: Modification des participants ===========================
    @PutMapping("/modifierPart")
    @Operation(summary = "Modifier un participant")
    @ApiResponse(responseCode = "200", description = "Participant modifié avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Participant non modifié")
    private String modifier(@Valid @RequestBody Participation participation){
        participationService.modifier(participation);
        return "Participant modifier";
    }

    //================================= End-Point: Suppression des participants ===========================
    @DeleteMapping("/supprimerPart")
    @Operation(summary = "Supprimer un participant")
    @ApiResponse(responseCode = "200", description = "Participant supprimé avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")
    private String supprimer(@RequestParam Long idParticipation){
        participationService.supprimer(idParticipation);
        return "Participation supprimé avec succes";
    }

    //================================= End-Point: Afficher les quiz pour les participants ===========================
    @GetMapping("/afficher")
    @Operation(summary = "Afficher toutes la liste de participation")
    @ApiResponse(responseCode = "200", description = "Affichée avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Erreur d'affichage")
    private List<String> afficher(){
        return participationService.recupererListQuiz();
    }
    //================================= End-Point: Jouer à un quiz ===========================
    @GetMapping("/{idUser}/{idQuiz}/play")
    @Operation(summary = "Jouer au Quiz")
    @ApiResponse(responseCode = "200", description = "Jeu lancé avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de lancement")
    private List<String> afficheJeux(@PathVariable Long idUser,@PathVariable Long idQuiz,@RequestParam(value = "choix",required = false) Integer choix){
        if (choix==null){
            return participationService.commencer(idUser,idQuiz);
        }else {
            return participationService.verificationDesReponse(idUser,idQuiz,choix);
        }
    }
}
