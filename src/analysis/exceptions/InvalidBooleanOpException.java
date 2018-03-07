package analysis.exceptions;

public class InvalidBooleanOpException extends Exception{

    public InvalidBooleanOpException(String message){
        super("ERRO SEMÂNTICO: " + message);
    }
}
