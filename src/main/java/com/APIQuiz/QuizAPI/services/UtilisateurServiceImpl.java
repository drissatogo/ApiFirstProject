package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    private UtilisateurRepository utilisateurRepository;    //injection

    @Override
    public Utilisateur inscrire(Utilisateur utilisateur) {
//        Utilisateur emailUser = utilisateurRepository.findByEmail(email);
        if (utilisateur==null){
            throw new RuntimeException("Information user incorrect");
        }else {
            return utilisateurRepository.save(utilisateur);
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
    public List<Utilisateur> listeUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur afficherParId(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public void supprimer(Long idUser) {
        if (idUser==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            utilisateurRepository.deleteById(idUser);
        }
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
