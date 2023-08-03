package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.ReponseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.ReponseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReponseServiceImpl implements IReponseService {

    private final ReponseRepository reponseRepository;  //injection

    //private ReponseRepository reponseRepository;    //injection


    @Override
    public List<Reponse> afficher() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse ajouter(Reponse reponse) {
        Reponse reponse1 = reponseRepository.findByTexte(reponse.getTexte());
        if (reponse1==null){
            return reponseRepository.save(reponse);
        }else {
            throw new EntityNotFoundException("Reponse existe deja");
        }
    }

    @Override
    public Reponse modifierReponse(Long idReponse, String text, int point, String status) {
        Reponse reponse = reponseRepository.findById(idReponse).orElse(null);
        if (reponse != null) {
            reponse.setTexte(text);
            reponse.setPoint(point);
            return reponseRepository.save(reponse);
        }
        return null;
    }

    @Override
    public Reponse modifierUnElemntReponse(Long idReponse,Reponse reponse) {
        Reponse reponseAModifier = reponseRepository.findById(reponse.getIdReponse())
                .orElseThrow(() -> new EntityNotFoundException("Reponse introuvable"));

        // Vérifiez si le champ point de l'objet reponse est différent de 0
        if (reponse.getPoint() != 0) {
            // Mettez à jour le champ point de l'objet reponseAModifier
            reponseAModifier.setPoint(reponse.getPoint());
        }

        // Mettez à jour d'autres champs de l'objet reponseAModifier si nécessaire
        reponseAModifier.setPoint(reponse.getPoint());
        reponseAModifier.setTexte(reponse.getTexte());

        // Sauvegardez les modifications dans la base de données
        return reponseRepository.save(reponseAModifier);
    }


    @Override
    public void supprimer(Long idReponse) { Reponse reponse = reponseRepository.findByIdReponse(idReponse);
        if (reponse!=null){
            reponseRepository.deleteById(idReponse);
        }else {
            throw new EntityNotFoundException("Identifiant n'existe pas");
        }
    }

    @Override
    public List<Reponse> afficherLesReponses() {
        return null;
    }

    @Override
    public Reponse afficher(Long idReponse) {
            return reponseRepository.findById(idReponse).orElse(null);
        }
    }




