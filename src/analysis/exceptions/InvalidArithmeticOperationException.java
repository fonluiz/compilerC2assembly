package analysis.exceptions;

public class InvalidArithmeticOpException extends Exception {

    public InvalidArithmeticOpException(String message){
        super("ERRO SEMÂNTICO - Operadores aritméticos: " + message);
    }
}
