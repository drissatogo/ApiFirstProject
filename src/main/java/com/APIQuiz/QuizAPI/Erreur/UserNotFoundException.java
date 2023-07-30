package com.APIQuiz.QuizAPI.Erreur;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
