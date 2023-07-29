package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
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

    public Question afficherParId(Long idQuestion){
        return questionRepository.findById(idQuestion).get();
    }

    public Question afficherParQuestion(Long idQuestion){
        return null; //questionRepository.findByIdQuestion(idQuestion);

    }

    @Override
    public List<Question> afficherParUser(Long idUser) {
        return null;
    }

    @Override
    public String supprimerQuestion(Long idQuestion) {
        questionRepository.deleteById(idQuestion);
        return "Question supprimée";
    }

    @Override
    public Question listParId(Long idQuestion) {
        return null;
    }
}
