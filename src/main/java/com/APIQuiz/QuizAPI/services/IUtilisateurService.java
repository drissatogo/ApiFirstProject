package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Utilisateur;

import java.util.HashMap;
import java.util.List;

public interface IUtilisateurService {

    Utilisateur inscrire(Utilisateur utilisateur);      // inscription de user
    String connexion(String username, String password);     //  connexion de user
    List<Utilisateur> afficher();      //  liste complet de user
    Utilisateur lire(Long id);     //  recuperer user par  id
    void supprimer(Long idUser);    // suppression de user
    Utilisateur modifier(Utilisateur iduser);       //  modifier


}
