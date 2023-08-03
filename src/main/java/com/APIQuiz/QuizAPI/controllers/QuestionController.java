package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IQuestionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
@Transactional
public class QuestionController {
    @Autowired
    private IQuestionService questionService; // Injection

    @PostMapping("/create")
    public String creerQuestion(@Valid @RequestBody Question question){
//        if (question!=null){
            questionService.creerQuestion(question);
                return "La question a ete cree";
//        }else {
//            return "information ";
//        }
    }
    @PutMapping("/update")
    public String modifierQuestion(@Valid @RequestBody Question question){
        questionService.modifierQuestion(question);
             return "La question a ete modifier";
    }
    @GetMapping("/list")
    public List<Question> listeQuestion(){
        return questionService.afficherQuestion();
    }

    @GetMapping("/listeParId")
    private Question lire(@RequestParam Long idQuestion){
         return questionService.lire(idQuestion);
    }

    @DeleteMapping("/delete")
    public String supprimerQuestion(@RequestParam Long idQuestion){
         questionService.supprimerQuestion(idQuestion);
            return "Question supprimer";
    }

}
