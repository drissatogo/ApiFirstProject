package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;

import java.util.HashMap;
import java.util.List;

public interface IParticipationService {
    Participation ajouter(Participation participation);      // inscription de user
    List<Participation> afficher();      //  liste complet de user
    Participation lire(Long idParticipation);     //  recuperer user par  id
    void supprimer(Long idParticipation);    // suppression de user
    Participation modifier(Participation participation);       //  modifier

    List<String> recupererListQuiz();

    List<String> commencer(Long idUser, Long idQuiz);

    List<String> verificationDesReponse(Long idUser,Long idQuiz,int choix);

}
