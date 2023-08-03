package com.APIQuiz.QuizAPI.services;
import com.APIQuiz.QuizAPI.entites.Reponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface IReponseService {
        List<Reponse> afficher();      //  afficher tous les reponses
        Reponse ajouter(Reponse reponse);      // enregistrer une reponse

        Reponse modifierReponse(Long idReponse, String text, int point, String status);

        Reponse modifierUnElemntReponse(Long idReponse,Reponse reponse);

        void supprimer(Long idReponse);    // suppression de reponse

        List<Reponse> afficherLesReponses(); //afficher une Reponse

        Reponse afficher(Long idReponse);
}

