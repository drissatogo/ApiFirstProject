package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByUsername(String username);
    Utilisateur findByPassword(String username);

//    Utilisateur findByquizUserAndQuestionUserAndReponseUserAndParticipationUser(Quiz quiz, Question question, Reponse reponse, Participation participation);
}
