package analysis.exceptions;

public class InvalidParametersException extends Exception{

    public InvalidParametersException(String message) {
        super("ERRO SEMÂNTICO: " + message);
    }
}
