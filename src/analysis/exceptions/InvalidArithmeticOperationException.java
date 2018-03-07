package analysis.exceptions;

public class InvalidArithmeticOperationException extends Exception {

    public InvalidArithmeticOperationException(String message){
        super("ERRO SEMÂNTICO: " + message);
    }
}
