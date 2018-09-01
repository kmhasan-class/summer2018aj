package bd.ac.seu.aj.springbootdemo.exception;

public class ResourceDoesNotExistException extends Error {
    public ResourceDoesNotExistException(String message) {
        super(message);
    }
}
