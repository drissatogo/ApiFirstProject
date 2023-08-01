package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IParticipationService;
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


    //    endpoint: ajouter Quiz
    @PostMapping("/ajouterPart")
    private String ajouter(@Valid @RequestBody Participation participation){
            participationService.ajouter(participation);
            return "Participant ajouter";
        }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllParticipant")
    private List<Participation> list(){
        return participationService.afficher();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdPart")
    private Participation quizIdList(@RequestParam Long idPart){
        return participationService.lire(idPart);
    }

    //    enpoint: modifier participation
    @PutMapping("/modifierPart")
    private String modifier(@Valid @RequestBody Participation participation){
        participationService.modifier(participation);
        return "Participant modifier";
    }

    //    endpoint: supprimer Participation
    @DeleteMapping("/supprimerPart")
    private String supprimer(@RequestParam Long idParticipation){
        participationService.supprimer(idParticipation);
        return "Participation supprimer avec succes";
    }

    @GetMapping("/")
    private List<String> afficher(){
        return participationService.recupererListQuiz();
    }

    @GetMapping("/{idUser}/{idQuiz}/play")
    private List<String> afficher(@PathVariable Long idUser,@PathVariable Long idQuiz,@RequestParam(value = "choix",required = false) Integer choix){
        if (choix==null){
            return participationService.commencer(idUser,idQuiz);
        }else {
            return participationService.verificationDesReponse(idUser,idQuiz,choix);
        }
    }

}
