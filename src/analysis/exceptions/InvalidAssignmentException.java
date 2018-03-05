package analysis.exceptions;

public class InvalidAssignmentException extends Exception {

    public InvalidAssignmentException(String message) {
        super("ERRO SEMÂNTICO: " + message);
    }

}
