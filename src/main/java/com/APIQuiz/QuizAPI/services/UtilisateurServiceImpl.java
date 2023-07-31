package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.Erreur.MessageErreur;
import com.APIQuiz.QuizAPI.Erreur.UserNotFoundException;
import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    private UtilisateurRepository utilisateurRepository;    //injection


    //====================== Inscription de l'utilisateur ================
    @Override
    public Utilisateur inscrire(Utilisateur utilisateur) {
        Utilisateur utilisateur1 = utilisateurRepository.save(utilisateur);
        if (utilisateur1==null){
            throw new UserNotFoundException("Remplissez les champs vides");
        }else {
            return utilisateurRepository.save(utilisateur1);
        }
    }
    //======================= Connexion de l'utilisateur =====================
    @Override
    public String connexion(String username, String password) {
        Utilisateur user = utilisateurRepository.findByUsername(username);
        if(user != null){
            if (user.getPassword().equals(password)){
                return "Connexion réussie";
            }else {
                return "Connexion échouée";
            }
        }else {
            return "Cet utilisateur n'existe pas";
        }

    }
    //===================== Liste des utilisateurs ============================
    @Override
    public List<Utilisateur> afficher() {
        return utilisateurRepository.findAll();
    }
    //===================== Liste par Id de l'utilisateur ============================
    @Override
    public Utilisateur lire(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.orElseThrow(
                ()-> new EntityNotFoundException("Aucun client n'existe avec cette identifiant")
        );
    }
    //===================== Suppression d'un utilisateur ============================
    @Override
    public void supprimer(Long idUser) {
        utilisateurRepository.deleteById(idUser);
    }
    //===================== Modifier un utilisateur ============================
    @Override
    public Utilisateur modifier(Utilisateur user) {
        if (user==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            return utilisateurRepository.save(user);
        }
    }

}
