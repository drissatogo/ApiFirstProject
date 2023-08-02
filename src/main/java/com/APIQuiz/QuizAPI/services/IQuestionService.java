package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Question;

import java.util.List;

public interface IQuestionService {
    Question creerQuestion(Question question);
    Question modifierQuestion(Question question);
    List<Question> afficherQuestion();
    Question lire(Long idQuestion);
    void supprimerQuestion(Long idQuestion);

}
