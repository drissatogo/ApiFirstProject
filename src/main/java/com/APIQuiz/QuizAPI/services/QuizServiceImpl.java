package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuizServiceImpl implements IQuizService{

    private QuizRepository quizRepository;    //injection

}
