package com.APIQuiz.QuizAPI.services;
import com.APIQuiz.QuizAPI.entites.Reponse;
import java.util.List;

public interface IReponseService {

    Reponse ajouter(Reponse reponse);      // enregistrer une reponse
    List<Reponse> afficher();      //  afficher tous les reponses
    Reponse lire(Long idReponse);     //  lire une reponse
    void supprimer(Long idReponse);    // suppression de reponse
    Reponse modifier(Reponse reponse);       //  modification de reponse
}
