package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.ReponseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReponseServiceImpl implements IReponseService{

    @Autowired
    private ReponseRepository reponseRepository;    //injection
    @Override
    public Reponse ajouter(Reponse reponse) {
        Reponse reponse1 = reponseRepository.findByTexte(reponse.getTexte());
        if (reponse1==null){
            return reponseRepository.save(reponse);
        }else {
           throw new EntityNotFoundException("Réponse existe déjà");
        }
    }

    @Override
    public List<Reponse> afficher() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse lire(Long idReponse) {
        return reponseRepository.findById(idReponse).orElseThrow(
                ()-> new EntityNotFoundException("Identifiant n'existe pas !")
        );

    }

    @Override
    public void supprimer(Long idReponse) {
        Reponse reponse = reponseRepository.findByIdReponse(idReponse);
        if (reponse!=null){
            reponseRepository.deleteById(idReponse);
        }else {
            throw new EntityNotFoundException("Identifiant n'existe pas");
        }
    }

    @Override
    public Reponse modifier(Reponse reponse) {
        Reponse reponse1 = reponseRepository.findByTexte(reponse.getTexte());
        if (reponse1==null){
            return reponseRepository.save(reponse);
        }else {
            throw new EntityNotFoundException("Réponse existe deja");
        }
    }
}
