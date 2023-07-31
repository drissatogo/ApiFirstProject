package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;

import java.util.HashMap;
import java.util.List;

public interface IParticipationService {
    Participation ajouter(Participation participation);      // inscription de user
    List<Participation> listeParticipant();      //  liste complet de user
    Participation afficherParId(Long idParticipation);     //  recuperer user par  id
    void supprimer(Long idParticipation);    // suppression de user
    Participation modifier(Participation participation);       //  modifier

    HashMap<String,String> resultat1(String titre,String username);

    List<String> recupererListQuiz();

    List<String> commencer(Long idUser, Long idQuiz);

    List<String> verificationDesReponse(Long idUser,Long idQuiz,int choix);

    HashMap<String,String> resultat(String username,String titre);

}
