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
@RequestMapping("quiz")
public class QuizController {

    private IQuizService quizService;

    //    endpoint: ajouter Quiz
    @PostMapping("/ajouterQuiz")
    private String ajouter(@Valid @RequestBody Quiz quiz){
        quizService.ajouter(quiz);
        return "Quiz a ete cree";
    }

    //    endpoint: afficher toute la liste
    @GetMapping("/listeAllQuiz")
    private List<Quiz> list(){
        return quizService.listeQuiz();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdQuiz")
    private Quiz quizIdList(@RequestParam Long idQuiz){
        return quizService.lire(idQuiz);
    }

    //    enpoint: modifier Quiz
    @PutMapping("/modifierQuiz")
    private Quiz modifier(@Valid @RequestBody Quiz quiz){
        return quizService.modifier(quiz);
    }

    //    endpoint: supprimer quiz
    @DeleteMapping("/supprimerQuiz")
    private String supprimer(@RequestParam Long idQuiz){
        quizService.supprimer(idQuiz);
        return "Quiz supprimer avec succes";
    }

}
