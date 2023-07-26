package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    Utilisateur inscrire(Utilisateur utilisateur);      // inscription de user
    String connexion(String username, String password);
    List<Utilisateur> listeUser();
    Utilisateur afficherParId(Long id);
    void supprimer(Long idUser);    // suppression de user
    String modifier(Long iduser);       //  modifier



}
