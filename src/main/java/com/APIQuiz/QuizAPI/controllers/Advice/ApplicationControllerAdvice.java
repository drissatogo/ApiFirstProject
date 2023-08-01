package com.APIQuiz.QuizAPI.controllers.Advice;

import com.APIQuiz.QuizAPI.Erreur.MessageErreur;
import com.APIQuiz.QuizAPI.Erreur.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.xml.sax.ErrorHandler;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody MessageErreur handlerException(EntityNotFoundException exception){
        return new MessageErreur(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

}
