package com.APIQuiz.QuizAPI.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Reponse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idReponse;

    @Column(name = "texte")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String texte;

    @Column(name = "status")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String bonneReponse;

    @Column(name = "point")
    @NotNull(message = "Remplissez les champs vides")
    @Max(value = 50, message = "Vous ne pouvez pas depasser 50 points")
    private int point;

    //=========================== Les rélations JPA ==============================
    @ManyToOne
    private Utilisateur utilisateurReponse;

    @ManyToOne
    private Question questionReponse;
}
