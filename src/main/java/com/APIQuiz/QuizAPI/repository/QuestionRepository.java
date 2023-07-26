package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
