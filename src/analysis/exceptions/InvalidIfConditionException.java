package analysis.exceptions;

public class InvalidIfConditionException extends  Exception {

    public InvalidIfConditionException(String message){
        super("ERRO SEMÂNTICO: " + message);
    }
}
