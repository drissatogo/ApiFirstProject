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


    //====================== Inscription de l'utilisateur ================
    @Override
    public Utilisateur inscrire(Utilisateur utilisateur) {
//        Utilisateur emailUser = utilisateurRepository.findByEmail(email);
        if (utilisateur==null){
            throw new RuntimeException("Information user incorrect");
        }else {
            return utilisateurRepository.save(utilisateur);
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
    public List<Utilisateur> listeUser() {
        return utilisateurRepository.findAll();
    }
    //===================== Liste par Id de l'utilisateur ============================
    @Override
    public Utilisateur afficherParId(Long id) {
        return utilisateurRepository.findById(id).get();
    }
    //===================== Suppression d'un utilisateur ============================
    @Override
    public void supprimer(Long idUser) {
        if (idUser==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            utilisateurRepository.deleteById(idUser);
        }
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
