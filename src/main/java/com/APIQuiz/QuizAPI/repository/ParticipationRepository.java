package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {

    Participation findByIdParticipation(Long idParticipation);

    Participation findByScore(int score);

//    pour recupere id de user et id de quiz etant dans participation
    Participation findByUtilisateurParticipationIdUserAndQuizParticipationIdQuiz(Long idUser,Long idQuiz);

}
