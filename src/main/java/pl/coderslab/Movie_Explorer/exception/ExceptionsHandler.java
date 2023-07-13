package pl.coderslab.Movie_Explorer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> badRequest(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(400).body("BAD REQUEST\n" + e.getLocalizedMessage());
    }
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> notFound(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(404).body("NOT FOUND\n" + e.getLocalizedMessage());
    }

    @ExceptionHandler(NotFoundContentException.class)
    public ResponseEntity<String> notFoundContent(NotFoundContentException e) {
        return ResponseEntity.status(404).body("NOT FOUND CONTENT");
    }
}
