package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByUsername(String username);      // chercher un user par son username
    Utilisateur findByPassword(String username);


    Utilisateur findByIdUser(Long id);

    Utilisateur findByUsernameAndPassword(String username, String password);

//    Utilisateur findByquizUserAndQuestionUserAndReponseUserAndParticipationUser(Quiz quiz, Question question, Reponse reponse, Participation participation);

}
