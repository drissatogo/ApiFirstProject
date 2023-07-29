package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse,Long> {
//    Reponse findBybonneReponse(String reponse);
}
