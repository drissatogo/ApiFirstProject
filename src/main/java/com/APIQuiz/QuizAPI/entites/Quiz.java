package com.APIQuiz.QuizAPI.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = {"quizUser","participationUser","questionUser"})
    private Utilisateur utilisateurQuiz;

    @OneToMany(mappedBy = "quizParticipation")
    //@JsonProperty(access = JsonProperty.Access.READ_WRITE)
    // autorise l'insertion seulement en format JSON
    @JsonIgnore
    private List<Participation> participationQuiz;

    @OneToMany(mappedBy = "quizQuestion")
    //@JsonProperty(access = JsonProperty.Access.READ_WRITE)  // autorise l'insertion seulement en format JSON
    @JsonIgnore
    private List<Question> questionQuiz;

}
