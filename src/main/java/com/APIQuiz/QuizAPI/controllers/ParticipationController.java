package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.services.IParticipationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ParticipationController {

    private IParticipationService participationService;

    //    endpoint: ajouter Quiz
    @PostMapping("/ajouterPart")
    @Operation(summary = "Ajout des participants")
    @ApiResponse(responseCode = "200", description = "Participant ajouté avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Participant non ajouté")

    private String ajouter(@Valid @RequestBody Participation participation){
        if (participation!=null){
            participationService.ajouter(participation);
            return "Participant ajouté";
        }else {
            return "Remplissez les champs vides";
        }
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllParticipant")
    @Operation(summary = "Liste de tous les participants")
    @ApiResponse(responseCode = "200", description = "Liste trouvé avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")
    private List<Participation> list(){
        return participationService.listeParticipant();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdPart")
    @Operation(summary = "Liste des participants par leur identifiant")
    @ApiResponse(responseCode = "200", description = "Liste trouvée",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")
    private ResponseEntity<Participation> quizIdList(@Valid @RequestParam Long idPart){
        if (idPart==null) throw new RuntimeException("Remplissez les champs vite");
        Participation participant = participationService.afficherParId(idPart);
        return ResponseEntity.ok(participant);
    }

    //    enpoint: modifier participation
    @PutMapping("/modifierPart")
    @Operation(summary = "Modifier un participant")
    @ApiResponse(responseCode = "200", description = "Participant modifié avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Participant non modifié")
    private Participation modifier(@Valid @RequestBody Participation participation){
        if (participation==null) throw new RuntimeException("Remplissez les champs vite");
        return participationService.modifier(participation);
    }

    //    endpoint: supprimer Participation
    @DeleteMapping("/supprimerPart")
    @Operation(summary = "Supprimer un participant")
    @ApiResponse(responseCode = "200", description = "Participant supprimé avec succès",
            content = @Content(schema = @Schema(implementation = Participation.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")
    private String supprimer(@Valid @RequestParam Long idParticipation){
        if (idParticipation==null) throw new RuntimeException("Choisissez un quiz");
        participationService.supprimer(idParticipation);
        return "Participation supprimé avec succes";
    }
}
