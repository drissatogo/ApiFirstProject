package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Utilisateur;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
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
        if (utilisateur==null /*&& emailUser.equals(email)*/){
            throw new RuntimeException("Champs vides");
        }else {
            return utilisateurRepository.save(utilisateur);
        }
    }

    @Override
    public String connexion(String username, String password) {
        return null;
    }

    @Override
    public List<Utilisateur> listeUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur afficherParId(Long id) {
        return null;
    }

    @Override
    public void supprimer(Long idUser) {

    }

    @Override
    public String modifier(Long iduser) {
        return null;
    }
}
