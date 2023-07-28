package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IQuestionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private IQuestionService questionService; // Injection

    @PostMapping("/create")
    public Question creerQuestion(@RequestBody Question question){
        return questionService.creerQuestion(question);
    }
    @PutMapping("/update")
    public Question modifierQuestion(@RequestBody Question question){
        return questionService.modifierQuestion(question);
    }
    @GetMapping("/list")
    public List<Question> listeQuestion(){
        return questionService.afficherQuestion();
    }

    @GetMapping("/listeParId")
    private ResponseEntity<Question> afficherQuestionParId(@Valid @RequestParam Long idQuestion){
        Question question = questionService.listParId(idQuestion);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/delete")
    public String supprimerQuestion(@RequestParam Long idQuestion){
        return questionService.supprimerQuestion(idQuestion);
    }
}
