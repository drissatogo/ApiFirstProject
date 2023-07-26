package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    private UtilisateurRepository utilisateurRepository;    //injection

}
