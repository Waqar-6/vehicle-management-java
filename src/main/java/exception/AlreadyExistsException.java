package exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String resource, String field, String value) {
        super(String.format("%s already exists with the given %s:'%s'", resource, field, value));
    }
}
