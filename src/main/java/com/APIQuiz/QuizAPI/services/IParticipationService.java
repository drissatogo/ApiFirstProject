package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;

import java.util.List;

public interface IParticipationService {
    Participation ajouter(Participation participation);      // inscription de user
    List<Participation> listeParticipant();      //  liste complet de user
    Participation afficherParId(Long idParticipation);     //  recuperer user par  id
    void supprimer(Long idParticipation);    // suppression de user
    Participation modifier(Participation participation);       //  modifier
}
