package analysis.exceptions;

public class InvalidIfElseOpException extends Exception {

    public InvalidIfElseOpException(String message){
        super("ERRO SEMÂNTICO - IF/ELSE: " +message);
    }
}
