package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IQuestionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Transactional
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
    @DeleteMapping("/delete")
    public String supprimerQuestion(@RequestParam("idQuestion") Long idQuestion){
        return questionService.supprimerQuestion(idQuestion);
    }
}
