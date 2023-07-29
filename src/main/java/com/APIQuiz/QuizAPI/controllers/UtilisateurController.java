package com.APIQuiz.QuizAPI.controllers;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
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
public class UtilisateurController {

    private IUtilisateurService utilisateurService;     //  injection

//    endpoint: Inscrire Utilisateur
    @PostMapping("/ajouter")
    @Operation(summary = "Ajout d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur ajouté avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Utilisateur non ajouté")

    private String inscrire(@Valid @RequestBody Utilisateur utilisateur){
        if (utilisateur!=null){
            utilisateurService.inscrire(utilisateur);
            return "Utilisateur ajouter";
        }else {
            return "Remplisser les champs vide";
        }
    }

//    endpoint: connecter Utilisateur
        @GetMapping("/connecter")
        @Operation(summary = "Permet la connexion d'un utilisateur")
        @ApiResponse(responseCode = "200", description = "Connecté avec succès",
                content = @Content(schema = @Schema(implementation = Utilisateur.class)))
        @ApiResponse(responseCode = "404", description = "Erreur de connexion")

        private String connecter(@RequestParam("username") String username, @RequestParam("password") String password){
        if (username!=null && password!=null){
           return utilisateurService.connexion(username,password)+"";
        }else {
            return "Remplisser les champs vides";
        }
    }

//    endpoint: afficher toute la liste
    @GetMapping("/listeAll")
    @Operation(summary = "Liste de tous les utilisateurs")
    @ApiResponse(responseCode = "200", description = "Liste trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    private List<Utilisateur> list(){
        return utilisateurService.listeUser();
    }

//    enpoint: afficher liste par id
    @GetMapping("/listeId")
    @Operation(summary = "Liste des utilisateurs par leur identifiant ")
    @ApiResponse(responseCode = "200", description = "Liste trouvé avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Liste non  trouvée")

    private ResponseEntity<Utilisateur> userAllList(@Valid @RequestParam Long idUser){
        if (idUser==null) throw new RuntimeException("Remplissez les champs vite");
        Utilisateur user = utilisateurService.afficherParId(idUser);
        return ResponseEntity.ok(user);
    }

//    enpoint: modifier Utilisateur
    @PutMapping("/modifierUser")
    @Operation(summary = "Modification d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur modifié avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Utilisateur non modifié")

    private Utilisateur modifier(@Valid @RequestBody Utilisateur user){
        if (user==null) throw new RuntimeException("Remplissez les champs vite");
        return utilisateurService.modifier(user);
    }

//    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerUser")
    @Operation(summary = "Suppression d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur supprimé avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")

    private String supprimer(@Valid @RequestParam("idUser") Long idUser){
        if (idUser==null) throw new RuntimeException("Choisissez un user");
        utilisateurService.supprimer(idUser);
        return "User supprimer avec succes";
    }


}
