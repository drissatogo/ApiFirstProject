package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuestionRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService{

    private QuestionRepository questionRepository;    //injection

}
