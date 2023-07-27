package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.repository.ReponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReponseServiceImpl implements IReponseService{

    @Autowired
    private ReponseRepository reponseRepository;    //injection

    @Override
    public Reponse getReponseById(Long id) {
        return reponseRepository.findById(id).orElse(null);
    }

    @Override
    public Reponse creerReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse modifierReponse(Long idReponse, String text) {
        Reponse reponse = reponseRepository.findById(idReponse).orElse(null);
        if (reponse != null) {
            reponse.setTexte(text);
            return reponseRepository.save(reponse);
        }
        return null;
    }

    @Override
    public void supprimerReponse(Long id) {
        reponseRepository.deleteById(id);
    }
}
