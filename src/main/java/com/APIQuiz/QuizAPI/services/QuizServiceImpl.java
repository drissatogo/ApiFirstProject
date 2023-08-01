package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class QuizServiceImpl implements IQuizService{

    private QuizRepository quizRepository;
    @Override
    public Quiz ajouter(Quiz quiz) {
        Quiz quiz1 = quizRepository.findByTitre(quiz.getTitre());
        if (quiz1==null){
            return quizRepository.save(quiz);
        }else {
            throw new EntityNotFoundException("Le titre du quiz existe deja");
        }
    }

    @Override
    public List<Quiz> listeQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz lire(Long idQuiz) {
        return quizRepository.findById(idQuiz).orElseThrow(
                ()-> new EntityNotFoundException("Quiz n'existe pas")
        );
    }

    @Override
    public void supprimer(Long idQuiz) {
        Quiz quiz1 = quizRepository.findByIdQuiz(idQuiz);
        if (quiz1!=null){
            quizRepository.deleteById(idQuiz);
        }else {
            throw new EntityNotFoundException("Quiz n'existe pas !");
        }
    }

    @Override
    public Quiz modifier(Quiz quiz) {
        Quiz quiz1 = quizRepository.findByTitre(quiz.getTitre());
        if (quiz1==null){
            return quizRepository.save(quiz);
        }else {
            throw new EntityNotFoundException("Le titre du quiz existe deja");
        }
    }
}
