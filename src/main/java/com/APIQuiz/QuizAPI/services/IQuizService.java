package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Quiz;

import java.util.List;

public interface IQuizService {
    Quiz ajouter(Quiz quiz);      // enregistrer un quiz
    List<Quiz> listeQuiz();      //  afficher tous les quiz
    Quiz lire(Long idQuiz);     //  lire un quiz
    void supprimer(Long idQuiz);    // suppression de quiz
    Quiz modifier(Quiz quiz);       //  modifier de quiz
}
