package pl.coderslab.Movie_Explorer.exception;

public class NotFoundContentException extends RuntimeException {
    public NotFoundContentException(String message) {
        super(message);
    }
}
