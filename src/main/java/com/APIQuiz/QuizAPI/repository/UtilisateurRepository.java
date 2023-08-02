package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByUsername(String username);      // chercher un user par son username
    Utilisateur findByUsernameAndPassword(String username,String password);
    Utilisateur findByIdUser(Long id);

}
