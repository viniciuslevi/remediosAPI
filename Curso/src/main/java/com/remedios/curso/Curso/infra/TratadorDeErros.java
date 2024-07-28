package com.remedios.curso.Curso.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tradador404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tradador400(MethodArgumentNotValidException ex){
        var errors  = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosError::new).toList());
    }
    public record DadosError (String field, String message){
        public DadosError (FieldError fieldError){
            this(fieldError.getDefaultMessage(), fieldError.getField());
        }
    }
}
