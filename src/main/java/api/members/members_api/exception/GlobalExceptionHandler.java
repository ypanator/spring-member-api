package api.members.members_api.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(NoSuchElementException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse("No Member with this id", exc.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(ConstraintViolationException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse("Required fields in JSON body missing", exc.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentTypeMismatchException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse("Invalid path variable provided", exc.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpMessageNotReadableException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse("Invalid request body provided", exc.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpRequestMethodNotSupportedException exc) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new ExceptionResponse("Not supported Http method used", exc.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(MemberNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(exc.getMessage(), ""));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(UserNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(exc.getMessage(), ""));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(UserAlreadyRegisteredException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exc.getMessage(), ""));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BadCredentialsException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse("Invalid credentials provided", exc.getMessage()));
    }
}
