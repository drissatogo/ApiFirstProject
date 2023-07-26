package com.APIQuiz.QuizAPI.repository;

import com.APIQuiz.QuizAPI.entites.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {
}
