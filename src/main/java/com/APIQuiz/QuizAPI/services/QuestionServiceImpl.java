package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService{

    private QuestionRepository questionRepository;    //injection

    @Override
    public Question creerQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question modifierQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> afficherQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> afficherParUser(Long idUser){
        return questionRepository.findByUtilisateurQuestionIdUser(idUser);
    }

    public Question afficherParQuestion(Long idQuestion){
        return questionRepository.findByIdQuestion(idQuestion);

    }

    @Override
    public Question supprimerQuestion(Long idQuestion) {
        return questionRepository.findByIdQuestion(idQuestion);
    }
}
