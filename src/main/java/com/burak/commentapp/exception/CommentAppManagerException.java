package com.burak.commentapp.exception;

import lombok.Getter;

@Getter
public class CommentAppManagerException extends RuntimeException {

    private final ErrorType errorType;

    public CommentAppManagerException(ErrorType errorType){
        super(errorType.getMessage());

        this.errorType = errorType;

    }

    public CommentAppManagerException(ErrorType errorType, String message){

        super(message);
        this.errorType = errorType;

    }
}
