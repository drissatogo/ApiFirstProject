package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Question;

import java.util.List;

public interface IQuestionService {
    Question creerQuestion(Question question);
    Question modifierQuestion(Question question);
    List<Question> afficherQuestion();
    List<Question> afficherParUser(Long idUser);
//    Question afficherParQuestion(Long idQuestion);
    String supprimerQuestion(Long idQuestion);

    Question listParId(Long idQuestion);
}
