package com.APIQuiz.QuizAPI.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestion;

    @Column(name = "texte")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String texte;

    @ManyToOne
    private Utilisateur utilisateurQuestion;

    @ManyToOne
    private Quiz quizQuestion;

    @OneToMany(mappedBy = "questionReponse")
    private List<Reponse> reponseQuestion;

}
