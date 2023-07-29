package com.APIQuiz.QuizAPI.services;

import com.APIQuiz.QuizAPI.entites.Participation;
import com.APIQuiz.QuizAPI.entites.Question;
import com.APIQuiz.QuizAPI.entites.Quiz;
import com.APIQuiz.QuizAPI.entites.Reponse;
import com.APIQuiz.QuizAPI.repository.ParticipationRepository;
import com.APIQuiz.QuizAPI.repository.QuizRepository;
import com.APIQuiz.QuizAPI.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public HashMap<String, String> resultat1(String titre, String username) {
        return null;
    }

    @Override
    public HashMap<String, String> resultat(String titre, String username) {
       /* Participation participation = participationRepository.findByQuizParticipationAndUtilisateurParticipation(
                quizRepository.findByTitre(titre),
                utilisateurRepository.findByUsername(username)
        );

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("titre",participation.getQuizParticipation().getTitre());
        hashMap.put("titre",participation.getUtilisateurParticipation().getUsername());*/
        return null; //hashMap;
    }

//    Methode pour recuperer la liste ds quiz
    @Override
    public List<String> recupererListQuiz() {
        List<String> listNom = new ArrayList<>();      // stocker le nom des quiz a retourner
        List<Quiz> listQuiz = quizRepository.findAll();  // recuperer et stocker des quiz
        listNom.add("Debut du jeu: Choisissez le numero du quiz ");
        listQuiz.forEach(quiz -> {
          listNom.add(listNom.size()+" : "+quiz.getTitre());
        });
        return listNom;

    }

//    Traitement du debut de jeux
    @Override
    public List<String> commencer(Long idUser, Long idQuiz) {
        Participation participation = participationRepository.findByUtilisateurParticipationIdUserAndQuizParticipationIdQuiz(idUser,idQuiz);
        if (participation==null){
            Participation participation1 = new Participation();
            participation1.setUtilisateurParticipation(utilisateurRepository.findByIdUser(idUser));
            participation1.setQuizParticipation(quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz()));
            participation1.setScore(0);
            participation1.setNiveau(1);
            participationRepository.save(participation1);
//          les questions a afficher
            Question question = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz()).getQuestionQuiz().get(0);
            List<String> listQuestionReponse = new ArrayList<>();
            listQuestionReponse.add("Selectionner un numero pour la bonne reponse");
            listQuestionReponse.add(question.getTexte());
            listQuestionReponse.add("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            question.getReponseQuestion().forEach(reponse -> {
                listQuestionReponse.add(listQuestionReponse.size()-2+ " : " +reponse.getTexte());
            });
            return listQuestionReponse;
        }else {
            Question question = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                    .getQuestionQuiz().get(participation.getNiveau()-1);
            List<String> listQuestionReponse = new ArrayList<>();
            listQuestionReponse.add("Selectionner un numero pour la bonne reponse");
            listQuestionReponse.add(question.getTexte());
            listQuestionReponse.add("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            question.getReponseQuestion().forEach(reponse -> {
                listQuestionReponse.add(listQuestionReponse.size()-2+ " : " +reponse.getTexte());
            });
            return listQuestionReponse;
        }
    }

    @Override
    public List<String> verificationDesReponse(Long idUser, Long idQuiz, int choix) {
        Participation participation = participationRepository.findByUtilisateurParticipationIdUserAndQuizParticipationIdQuiz(idUser,idQuiz);
        Question question = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                .getQuestionQuiz().get(participation.getNiveau()-1);
        Reponse reponse = question.getReponseQuestion().get(choix-1);
        List<String>  listReponse = new ArrayList<>();
        if (reponse.getBonneReponse().equals("vrai")){
            List<Question> questionList = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                    .getQuestionQuiz();
            if (questionList.size()>=participation.getNiveau()+1){
                participation.setScore(participation.getScore()+10);
                participation.setNiveau(participation.getNiveau()+1);
                participationRepository.save(participation);
                question = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                        .getQuestionQuiz().get(participation.getNiveau()-1);
                listReponse.add("Felicitation vous avez trouver la bonne reponse");
                listReponse.add("Votre score est de " +participation.getScore()+ "points");
                listReponse.add("Passer a la question suivantes");
                listReponse.add(question.getTexte());
                listReponse.add("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
                question.getReponseQuestion().forEach(reponse1 -> {
                    listReponse.add(listReponse.size()-4 + " : " +reponse.getTexte());
                });
                return listReponse;
            }else {
                participation.setScore(participation.getScore()+10);
                participationRepository.save(participation);
                listReponse.add("Felicitation vous avez trouver la bonne reponse");
                listReponse.add("Jeu terminer !!!");
                listReponse.add("Votre score final est :" +participation.getScore()+ "points");
                return listReponse;
            }
        }else {
            List<Question> questionList = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                    .getQuestionQuiz();
            if (questionList.size()>=participation.getNiveau()+1){
                participation.setNiveau(participation.getNiveau()+1);
                participationRepository.save(participation);
                Question question1 = quizRepository.findByIdQuiz(quizRepository.findAll().get((int)(idQuiz-1)).getIdQuiz())
                        .getQuestionQuiz().get(participation.getNiveau()-1);
                question.getReponseQuestion().forEach(reponse1 -> {
                    if (reponse1.getBonneReponse().equals("vrai")){
                        listReponse.add("Vous n'avez pas trouver la bonne reponse");
                        listReponse.add("Voici la reponse: " +reponse1.getTexte());
                    }
                });
                listReponse.add("Passer a la question suivante");
                listReponse.add(question1.getTexte());
                listReponse.add("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
                question1.getReponseQuestion().forEach(reponse2 -> {
                    listReponse.add(listReponse.size()-4 +" : "+reponse2.getTexte());
                });
                return listReponse;
            }else {
                question.getReponseQuestion().forEach(reponse1 -> {
                    if (reponse1.getBonneReponse().equals("vrai")){
                        listReponse.add("Vous n'avez pas trouver la bonne reponse");
                        listReponse.add("Voici la reponse: " +reponse1.getTexte());
                    }
                });
                listReponse.add("Jeu terminer !!!");
                listReponse.add("Votre score final est :" +participation.getScore()+ "points");
                return listReponse;
            }

        }

    }


}
