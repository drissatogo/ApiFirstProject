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

    @Override
    public Utilisateur inscrire(Utilisateur utilisateur) {
        Utilisateur utilisateurVerif = utilisateurRepository.findByUsername(utilisateur.getUsername());
        if (utilisateurVerif == null){
            return utilisateurRepository.save(utilisateur);
        }else {
            throw new EntityNotFoundException("User existe deja !");
        }
    }

    @Override
    public String connexion(String username, String password) {
        Utilisateur user = utilisateurRepository.findByUsername(username);
        Utilisateur pass = utilisateurRepository.findByPassword(password);
        if (pass.getPassword().equals(password) && user.getUsername().equals(username)){
            return "Connexion reussit";
        }else {
            return "Connexion echoue";
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur lire(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.orElseThrow(
                ()-> new EntityNotFoundException("Aucun client n'existe avec cette identifiant")
        );
    }

    @Override
    public void supprimer(Long idUser) {
        utilisateurRepository.deleteById(idUser);
    }

    @Override
    public Utilisateur modifier(Utilisateur user) {
        if (user==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            return utilisateurRepository.save(user);
        }
    }

}
