package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);
}
