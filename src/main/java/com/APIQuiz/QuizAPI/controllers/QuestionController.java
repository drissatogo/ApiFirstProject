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

    @PostMapping("/create")
    @Operation(summary = "Création des questions ")
    @ApiResponse(responseCode = "200", description = "Question crée avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Question non crée")

    public Question creerQuestion(@RequestBody Question question){
        return questionService.creerQuestion(question);
    }
    @PutMapping("/update")
    @Operation(summary = "Mise à jour des questions ")
    @ApiResponse(responseCode = "200", description = "Question mis à jour avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Question non mis à jour")

    public Question modifierQuestion(@RequestBody Question question){
        return questionService.modifierQuestion(question);
    }
    @GetMapping("/list")
    @Operation(summary = "Liste des questions ")
    @ApiResponse(responseCode = "200", description = "Liste trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    public List<Question> listeQuestion(){
        return questionService.afficherQuestion();
    }

    @GetMapping("/listeParId")
    private ResponseEntity<Question> afficherQuestionParId(@Valid @RequestParam Long idQuestion){
        Question question = questionService.listParId(idQuestion);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Supprimer des questions ")
    @ApiResponse(responseCode = "200", description = "Question supprimée avec succès",
            content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")

    public String supprimerQuestion(@RequestParam ("idQuestion") Long idQuestion){
        return questionService.supprimerQuestion(idQuestion);
    }
}
