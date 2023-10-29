package br.com.gmbconsulting.approvalsystem.infra;

import br.com.gmbconsulting.approvalsystem.infra.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionGeneric(Exception e){
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity userException(UserException e){
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_GATEWAY);
    }
}
