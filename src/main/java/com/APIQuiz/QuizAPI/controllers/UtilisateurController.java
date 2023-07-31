package com.APIQuiz.QuizAPI.controllers;
import com.APIQuiz.QuizAPI.Erreur.MessageErreur;
import com.APIQuiz.QuizAPI.Erreur.UserNotFoundException;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.services.IUtilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private IUtilisateurService utilisateurService;     //  injection

//    endpoint: Inscrire Utilisateur
    @PostMapping("/ajouter")
    @Operation(summary = "Ajout d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur ajouté avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Utilisateur non ajouté")
    private ResponseEntity inscrire(@Valid @RequestBody Utilisateur utilisateur){
        //try{
            utilisateurService.inscrire(utilisateur);
            return ResponseEntity.status(HttpStatus.CREATED).body(utilisateur);
        //}catch (UserNotFoundException exception){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageErreur("Utilisateur existe deja","Changer d'information"));
        //}

    }

//    endpoint: connecter Utilisateur
        @GetMapping("/connecter")
        @Operation(summary = "Permet la connexion d'un utilisateur")
        @ApiResponse(responseCode = "200", description = "Connecté avec succès",
                content = @Content(schema = @Schema(implementation = Utilisateur.class)))
        @ApiResponse(responseCode = "404", description = "Erreur de connexion")
        private String connecter(@RequestParam String username, @RequestParam String password){
            utilisateurService.connexion(username,password);
           return "Connexion reussit";
    }

//    endpoint: afficher toute la liste
    @GetMapping("/listeAll")
    @Operation(summary = "Liste de tous les utilisateurs")
    @ApiResponse(responseCode = "200", description = "Liste trouvée avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Liste non trouvée")

    private List<Utilisateur> list(){
        return utilisateurService.afficher();
    }

//    enpoint: afficher liste par id
    @GetMapping("/listeId")
    @Operation(summary = "Liste des utilisateurs par leur identifiant ")
    @ApiResponse(responseCode = "200", description = "Liste trouvé avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Liste non  trouvée")
    private Utilisateur userAllList(@RequestParam Long idUser) {
           return utilisateurService.lire(idUser);
    }

//    enpoint: modifier Utilisateur
    @PutMapping("/modifierUser")
    @Operation(summary = "Modification d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur modifié avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Utilisateur non modifié")

    private Utilisateur modifier(@Valid @RequestBody Utilisateur user){
        return utilisateurService.modifier(user);
    }

//    endpoint: supprimer Utilisateur
    @DeleteMapping("/supprimerUser")
    @Operation(summary = "Suppression d'un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur supprimé avec succès",
            content = @Content(schema = @Schema(implementation = Utilisateur.class)))
    @ApiResponse(responseCode = "404", description = "Erreur de suppression")
    private String supprimer(@Valid @RequestParam Long idUser){
        utilisateurService.supprimer(idUser);
        return "User supprimé avec succes";
    }
}
