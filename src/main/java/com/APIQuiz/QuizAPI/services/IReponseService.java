package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Reponse;
import lombok.AllArgsConstructor;
import lombok.Data;


public interface IReponseService {



        Reponse getReponseById (Long idReponse);

        Reponse creerReponse(Reponse reponse);

        Reponse modifierReponse(Long id, String text);

        void supprimerReponse(Long id);

    }
