package ie.atu.moniveabc_oop_project.ExceptionHandler;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class exceptionHandler {

@ExceptionHandler(value={MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    return ResponseEntity.badRequest().body("there was an error validating the request");


    }

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
        errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> handleMemeberNotFound(MemberNotFoundException ex){

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

}
