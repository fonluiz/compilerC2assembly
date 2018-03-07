package analysis.exceptions;

/**
 * Created by luiz on 06/03/18.
 */
public class FunctionDefinitionException extends Exception {

    public FunctionDefinitionException(String message) {
        super("ERRO SEMÂNTICO: " + message);
    }
}
