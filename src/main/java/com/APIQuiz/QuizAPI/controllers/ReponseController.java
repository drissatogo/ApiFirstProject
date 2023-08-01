package com.APIQuiz.QuizAPI.controllers;


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

}
