package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.services.IQuizService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuizController {

    private IQuizService quizService;

    //    endpoint: ajouter Quiz
    @PostMapping("/ajouterQuiz")
    private String ajouter(@Valid @RequestBody Quiz quiz){
        if (quiz!=null){
            quizService.ajouter(quiz);
            return "Quiz ajouter";
        }else {
            return "Remplisser les champs vide";
        }
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllQuiz")
    private List<Quiz> list(){
        return quizService.listeQuiz();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdQuiz")
    private ResponseEntity<Quiz> quizIdList(@Valid @RequestParam Long idQuiz){
        if (idQuiz==null) throw new RuntimeException("Remplissez les champs vite");
        Quiz quiz = quizService.afficherParId(idQuiz);
        return ResponseEntity.ok(quiz);
    }

    //    enpoint: modifier Quiz
    @PutMapping("/modifierQuiz")
    private Quiz modifier(@Valid @RequestBody Quiz quiz){
        if (quiz==null) throw new RuntimeException("Remplissez les champs vite");
        return quizService.modifier(quiz);
    }

    //    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerQuiz")
    private String supprimer(@Valid @RequestParam Long idQuiz){
        if (idQuiz==null) throw new RuntimeException("Choisissez un quiz");
        quizService.supprimer(idQuiz);
        return "Quiz supprimer avec succes";
    }

}
