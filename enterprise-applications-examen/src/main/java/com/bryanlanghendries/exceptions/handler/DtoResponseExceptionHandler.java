package com.bryanlanghendries.exceptions.handler;

import com.bryanlanghendries.exceptions.BadInputException;
import com.bryanlanghendries.exceptions.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class DtoResponseExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handleEntityNotFound(final EntityNotFoundException ex){
        log.error("Error occurred: ", ex);
        return ResponseEntity.status(204).build();
    }

    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<Void> handleBadInput(final BadInputException ex){
        log.error("Error occurred: ", ex);
        return ResponseEntity.status(400).build();
    }
}
