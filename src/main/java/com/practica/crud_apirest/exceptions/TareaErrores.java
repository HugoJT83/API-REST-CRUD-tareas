package com.practica.crud_apirest.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.client.HttpClientErrorException.UnsupportedMediaType;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class TareaErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityNotFoundException(EntityNotFoundException ERROR){
        return new ResponseEntity<>("Error: la tarea no existe.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlerDataIntegrityViolationException(DataIntegrityViolationException ERROR){
        return new ResponseEntity<>("Error: El tipo de dato no es válido para el campo.",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedMediaType.class)
    public ResponseEntity<String> handlerUnsupportedMediaType(UnsupportedMediaType ERROR){
        return new ResponseEntity<>("La petición PUT, POST, PATCH o DELETE no es válida",HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(MethodNotAllowed.class)
    public ResponseEntity<String> handlerMethodNotAllowed(MethodNotAllowed ERROR){
        return new ResponseEntity<>("La petición al servidor no está permitida.",HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<String> handlerInternalServerError(InternalServerError ERROR){
        return new ResponseEntity<>("Ha ocurrido un error inesperado en el servidor",HttpStatus.INTERNAL_SERVER_ERROR);
    } 

    

}
