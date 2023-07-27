package com.APIQuiz.QuizAPI.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    //====================== Pour le nom =========================
    @Column(name = "nom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nom;

    //====================== Pour le prenom =========================
    @Column(name = "prenom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String prenom;

    //====================== Pour l'email =========================
    @Column(name = "email")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    @Email(message = "Entrez un email valide !")
    private String email;


    //====================== Pour le username =========================
    @Column(name = "username")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String username;

    //====================== Pour le mot de passe =========================
    @Column(name = "password")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String password;

    //====================== Pour les relations JPA =========================
    @OneToMany(mappedBy = "utilisateurQuiz")
    @JsonIgnoreProperties(value = {"utilisateurQuiz","questionQuiz"})
    private List<Quiz> quizUser;

    @OneToMany(mappedBy = "utilisateurQuestion")
    @JsonIgnoreProperties(value = {"utilisateurQuestion","quizQuestion"})
    private List<Question> questionUser;

    @OneToMany(mappedBy = "utilisateurReponse")
    @JsonIgnoreProperties(value = {"utilisateurReponse"})
    private List<Reponse> reponseUser;

    @OneToMany(mappedBy = "utilisateurParticipation")
    @JsonIgnoreProperties(value = {"utilisateurParticipation"})
    private List<Participation> participationUser;


}
