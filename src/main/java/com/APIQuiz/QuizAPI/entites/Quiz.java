package com.APIQuiz.QuizAPI.entites;



import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Participation> participationQuiz;

    @OneToMany(mappedBy = "quizQuestion",orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // autorise l'insertion seulement en format JSON
    private List<Question> questionQuiz;

}
