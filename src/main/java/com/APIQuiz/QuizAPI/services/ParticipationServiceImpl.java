package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationServiceImpl implements IParticipationService{

    private ParticipationRepository participationRepository;    //injection
    private UtilisateurRepository utilisateurRepository;
    private QuizRepository quizRepository;


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

    @Override
    public HashMap<String,String> resultat(String username, String titre) {
        Participation resultat = participationRepository.findByUtilisateurParticipationAndQuizParticipation(
                utilisateurRepository.findByUsername(username),
                quizRepository.findByTitre(titre)
        );
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",resultat.getUtilisateurParticipation().getUsername());
        hashMap.put("titre",resultat.getQuizParticipation().getTitre());
        hashMap.put("score",resultat.getScore()+"");
        return hashMap;
    }
}
