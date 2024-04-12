package com.bryanlanghendries.exceptions.handler;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class DtoResponseExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlEntityNotFound(final EntityNotFoundException ex){
        log.error("Error occured: ", ex);
        return ResponseEntity.noContent().build();
    }
}
