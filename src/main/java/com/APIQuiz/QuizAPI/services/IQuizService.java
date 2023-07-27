package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Quiz;

import java.util.List;

public interface IQuizService {
    Quiz ajouter(Quiz quiz);      // inscription de quiz
    List<Quiz> listeQuiz();      //  liste complet de quiz
    Quiz afficherParId(Long idQuiz);     //  recuperer user par  id
    void supprimer(Long idQuiz);    // suppression de quiz
    Quiz modifier(Quiz quiz);       //  modifier
}
