package exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s not found with the given %s:'%s'", resource, field, value));
    }
}
