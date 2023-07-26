package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParticipationServiceImpl implements IParticipationService{

    private ParticipationRepository participationRepository;    //injection

}
