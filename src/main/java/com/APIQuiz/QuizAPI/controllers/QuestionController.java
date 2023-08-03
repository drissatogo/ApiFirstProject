package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.services.IQuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    //================================= End-Point: Création des questions ===========================
    @PostMapping("/create")
        @Operation(summary = "Création des questions ")
        @ApiResponse(responseCode = "200", description = "Question crée avec succès",
                content = @Content(schema = @Schema(implementation = Question.class)))
        @ApiResponse(responseCode = "404", description = "Question non crée")

        public String creerQuestion(@Valid @RequestBody Question question){
//        if (question!=null){
            questionService.creerQuestion(question);
                return "La question a été crée";
//        }else {
//            return "information ";
//        }
    }
    //================================= End-Point: Mise à jour des questions ===========================
    @PutMapping("/update")
    @Operation(summary = "Mise à jour des questions ")
    @ApiResponse(responseCode = "200", description = "Question mis à jour avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Question non mis à jour")
    public String modifierQuestion(@Valid @RequestBody Question question){
        questionService.modifierQuestion(question);
             return "La question a été modifiée";
    }
    //================================= End-Point: Liste des questions ================================
    @GetMapping("/list")
    @Operation(summary = "Liste des questions ")
    @ApiResponse(responseCode = "200", description = "Liste trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    public List<Question> listeQuestion(){
        return questionService.afficherQuestion();
    }

    //================================= End-Point: Affichage des questions par identifiant ===========================
    @GetMapping("/listeParId")
    private Question lire(@RequestParam Long idQuestion){
         return questionService.lire(idQuestion);
    }
    //================================= End-Point: Suppression des questions ================================
    @DeleteMapping("/delete")
    @Operation(summary = "Supprimer des questions ")
    @ApiResponse(responseCode = "200", description = "Question supprimée avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")
    public String supprimerQuestion(@RequestParam Long idQuestion){
         questionService.supprimerQuestion(idQuestion);
            return "Question supprimer";
    }

}
