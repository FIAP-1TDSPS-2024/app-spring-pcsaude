package br.com.pcsaude.config;

import br.com.pcsaude.exceptions.ResourceNotFoundException;
import br.com.pcsaude.exceptions.UniqueKeyDuplicadaException;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UniqueKeyDuplicadaException.class)
    public ResponseEntity<ErrorResponse> handleUniqueKeyDuplicadaException(ResourceNotFoundException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        final ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        e.printStackTrace();
        Map<String, String> errorResult = Map.of("error", "ops... ocorreu um erro inesperado");
        return ResponseEntity.internalServerError().body(errorResult);
    }

    @Getter
    public static class ErrorResponse {

        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }
    }
}
