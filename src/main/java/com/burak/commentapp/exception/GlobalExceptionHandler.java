package com.burak.commentapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return  ResponseEntity.badRequest().body("Beklenmeyen bir hata oldu" + ex.getMessage());

    }

    @ExceptionHandler(CommentAppManagerException.class)
    public ResponseEntity<ErrorMessage> handleCommentAppManagerException(CommentAppManagerException ex){
        ErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus =errorType.getHttpStatus();

        return new  ResponseEntity(createError(errorType, ex), httpStatus);

    }

    /**
     * Error mesajlarınızı özel bir method içinde create edilir. cünkü oluşan hataların log lanması ya da farklı işlemlere tabi
     * tutulması için ayrıca bir method kullanmak daha doğru olacaktır.
     *
     */

    private ErrorMessage createError(ErrorType errorType, Exception exception){
        System.out.println("Hata oluştu..:" + exception.getMessage());
        return ErrorMessage.builder().code(errorType.getCode()).message(errorType.getMessage()).build();
    }
}

