package ie.atu.moniveabc_oop_project.ExceptionHandler;

public class MemberAlreadyExistsException extends RuntimeException {
    public MemberAlreadyExistsException(String message) {
        super(message);
    }
}
