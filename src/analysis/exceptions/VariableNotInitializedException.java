package analysis.exceptions;

public class VariableNotInitializedException extends Exception{

    public VariableNotInitializedException(String message) {
        super("ERRO SEMÂNTICO: " + message);
    }
}
