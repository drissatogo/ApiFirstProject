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
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;

    @Column(name = "titre")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String titre;

    @Column(name = "domaine")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String domaine;

    @ManyToOne
    private Utilisateur utilisateurQuiz;

    @OneToMany(mappedBy = "quizParticipation")
    private List<Participation> participationQuiz;

    @OneToMany(mappedBy = "quizQuestion")
    private List<Question> questionQuiz;

}
