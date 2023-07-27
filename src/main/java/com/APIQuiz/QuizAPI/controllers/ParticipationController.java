package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.services.IParticipationService;
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
    private String ajouter(@Valid @RequestBody Participation participation){
        if (participation!=null){
            participationService.ajouter(participation);
            return "Participant ajouter";
        }else {
            return "Remplisser les champs vide";
        }
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllParticipant")
    private List<Participation> list(){
        return participationService.listeParticipant();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdPart")
    private ResponseEntity<Participation> quizIdList(@Valid @RequestParam Long idPart){
        if (idPart==null) throw new RuntimeException("Remplissez les champs vite");
        Participation participant = participationService.afficherParId(idPart);
        return ResponseEntity.ok(participant);
    }

    //    enpoint: modifier participation
    @PutMapping("/modifierPart")
    private Participation modifier(@Valid @RequestBody Participation participation){
        if (participation==null) throw new RuntimeException("Remplissez les champs vite");
        return participationService.modifier(participation);
    }

    //    endpoint: supprimer Participation
    @DeleteMapping("/supprimerPart")
    private String supprimer(@Valid @RequestParam Long idParticipation){
        if (idParticipation==null) throw new RuntimeException("Choisissez un quiz");
        participationService.supprimer(idParticipation);
        return "Participation supprimer avec succes";
    }
}
