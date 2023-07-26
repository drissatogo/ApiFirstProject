package com.APIQuiz.QuizAPI.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "nom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nom;

    @Column(name = "prenom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String prenon;

    @Column(name = "email")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    @Email(message = "Entrez un email valide !")
    private String email;

    @Column(name = "username")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String password;

    @OneToMany(mappedBy = "utilisateurQuiz")
    private List<Quiz> quizUser;

    @OneToMany(mappedBy = "utilisateurQuestion")
    private List<Question> questionUser;

    @OneToMany(mappedBy = "utilisateurReponse")
    private List<Reponse> reponseUser;

    @OneToMany(mappedBy = "utilisateurParticipation")
    private List<Participation> participationUser;


}
