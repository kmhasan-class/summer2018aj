package bd.ac.seu.aj.springbootdemo.exception;

public class ResourceAlreadyExistsException extends Error {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
