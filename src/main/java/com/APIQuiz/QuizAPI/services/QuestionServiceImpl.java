package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.Erreur.NotFoundException;
import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
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
        Question question1 = questionRepository.findByTexte(question.getTexte());
        if (question1==null){
            return questionRepository.save(question);
        }else {
            throw new EntityNotFoundException("Question existe deja !");
        }
    }

    @Override
    public Question modifierQuestion(Question question) {
        Question question1 = questionRepository.findByTexte(question.getTexte());
        if (question1==null){
            return questionRepository.save(question);
        }else {
            throw new EntityNotFoundException("texte existe deja !");
        }
    }

    @Override
    public List<Question> afficherQuestion() {
        return questionRepository.findAll();
    }

    public Question lire(Long idQuestion){
        return questionRepository.findById(idQuestion).orElseThrow(
                ()-> new NotFoundException("Cet identifiant n'existe pas !")
        );
    }

    @Override
    public void supprimerQuestion(Long idQuestion) {
        Question question = questionRepository.findByidQuestion(idQuestion);
        if (question!=null){
            questionRepository.deleteById(idQuestion);
        }else {
            throw new EntityNotFoundException("identifiant n'existe pas !");
        }
    }
}
