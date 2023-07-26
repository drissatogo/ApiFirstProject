package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.ReponseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReponseServiceImpl implements IReponseService{

    private ReponseRepository reponseRepository;    //injection

}
