package com.APIQuiz.QuizAPI.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Participation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipation;

    @Column(name = "score")
    @NotNull(message = "Remplissez les champs vides")
    @Max(value = 500, message = "Vous ne pouvez pas depasser 400 points")
    private int score;

    @Column(name = "niveau")
    @NotNull(message = "Remplisse les champs vides")
    @Max(value = 50, message = "Vous ne pouvez pas depasser 50 niveau")
    private int niveau;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Utilisateur utilisateurParticipation;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Quiz quizParticipation;
}
