package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Reponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface IReponseService {
        Reponse getReponseById (Long idReponse);

        Reponse creerReponse(Reponse reponse);

        Reponse modifierReponse(Long idReponse, String text, int point, String status);

        Reponse modifierUnElemntReponse(Long idReponse,Reponse reponse);

        void supprimerReponse(Long id);

        List<Reponse> afficherLesReponses(); //afficher une Reponse

    }
