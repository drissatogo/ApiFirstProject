package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationServiceImpl implements IParticipationService{

    private ParticipationRepository participationRepository;    //injection


    @Override
    public Participation ajouter(Participation participation) {
        if (participation==null){
            throw new RuntimeException("Information user incorrect");
        }else {
            return participationRepository.save(participation);
        }
    }

    @Override
    public List<Participation> listeParticipant() {
        return participationRepository.findAll();
    }

    @Override
    public Participation afficherParId(Long idParticipation) {
        return participationRepository.findById(idParticipation).get();
    }

    @Override
    public void supprimer(Long idParticipation) {
        if (idParticipation==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            participationRepository.deleteById(idParticipation);
        }
    }

    @Override
    public Participation modifier(Participation participation) {
        if (participation==null){
            throw new RuntimeException("Remplissez les champs vides");
        }else {
            return participationRepository.save(participation);
        }
    }
}
