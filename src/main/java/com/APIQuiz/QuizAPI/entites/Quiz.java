package com.APIQuiz.QuizAPI.entites;


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
    private Utilisateur utilisateurQuiz;

    @OneToMany(mappedBy = "quizParticipation")
<<<<<<< HEAD
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)  // autorise l'insertion seulement en format JSON
=======
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
>>>>>>> caecfff3070d3a8d3c6466b86e7dc3b4deefeabf
    private List<Participation> participationQuiz;

    @OneToMany(mappedBy = "quizQuestion")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // autorise l'insertion seulement en format JSON
    private List<Question> questionQuiz;

}
