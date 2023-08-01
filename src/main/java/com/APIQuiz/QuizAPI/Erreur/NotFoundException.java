package com.APIQuiz.QuizAPI.Erreur;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
