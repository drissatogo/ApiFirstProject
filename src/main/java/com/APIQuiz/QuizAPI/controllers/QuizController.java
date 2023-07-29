package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.services.IQuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Récupère toute la liste des quiz")
    @ApiResponse(responseCode = "200", description = "La liste des quiz a été trouvé",
            content = @Content(schema = @Schema(implementation = Quiz.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    private List<Quiz> list(){
        return quizService.listeQuiz();
    }

    //    enpoint: afficher liste par id
    @GetMapping("/listeIdQuiz")
    @Operation(summary = "Récupère toute la liste des quiz par son identifiant")
    @ApiResponse(responseCode = "200", description = "La liste a été trouvé",
            content = @Content(schema = @Schema(implementation = Quiz.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    private ResponseEntity<Quiz> quizIdList(@Valid @RequestParam Long idQuiz){
        if (idQuiz==null) throw new RuntimeException("Remplissez les champs vite");
        Quiz quiz = quizService.afficherParId(idQuiz);
        return ResponseEntity.ok(quiz);
    }

    //    enpoint: modifier Quiz
    @Operation(summary = "Modifier un quiz")
    @ApiResponse(responseCode = "200", description = "Quiz a été modifier",
            content = @Content(schema = @Schema(implementation = Quiz.class)))
    @ApiResponse(responseCode = "404", description = "Quiz non modifié")
    @PutMapping("/modifierQuiz")

    private Quiz modifier(@Valid @RequestBody Quiz quiz){
        if (quiz==null) throw new RuntimeException("Remplissez les champs vite");
        return quizService.modifier(quiz);
    }

    //    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerQuiz")
    @Operation(summary = "Supprimer un quiz")
    @ApiResponse(responseCode = "200", description = "Quiz supprimé avec succès",
            content = @Content(schema = @Schema(implementation = Quiz.class)))
    @ApiResponse(responseCode = "404", description = "Quiz non supprimé")

    private String supprimer(@Valid @RequestParam Long idQuiz){
        if (idQuiz==null) throw new RuntimeException("Choisissez un quiz");
        quizService.supprimer(idQuiz);
        return "Quiz supprimé avec succes";
    }

}
