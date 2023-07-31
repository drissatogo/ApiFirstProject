package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class QuizServiceImpl implements IQuizService{

    private QuizRepository quizRepository;


    //===================== Ajout d'un quiz ============================
    @Override
    public Quiz ajouter(Quiz quiz) {
        if (quiz==null){
            throw new RuntimeException("Information user incorrect");
        }else {
            return quizRepository.save(quiz);
        }
    }

    //===================== Liste de tous les Quiz ============================
    @Override
    public List<Quiz> listeQuiz() {
        return quizRepository.findAll();
    }
    //===================== Liste des Quiz en fonction de Id ============================
    @Override
    public Quiz afficherParId(Long idQuiz) {
        return quizRepository.findById(idQuiz).get();
    }

    @Override
    public void supprimer(Long idQuiz) {
        if (idQuiz==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            quizRepository.deleteById(idQuiz);
        }
    }

    @Override
    public Quiz modifier(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
