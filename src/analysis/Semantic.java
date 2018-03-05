package analysis;

import analysis.exceptions.InvalidAssignmentException;
import analysis.models.Types;
import analysis.models.Variable;

import java.util.HashMap;

public class Semantic {

    private static Semantic semantic = new Semantic();
    private HashMap<String, Types> variables = new HashMap<>();

    private Semantic() {}

    public static Semantic getInstance() {
        return semantic;
    }

    // DECLARAÇÕES E ATRIBUIÇÕES
    public void addVariable(Variable v) {
        variables.put(v.getName(), v.getType()) ;
    }

    public HashMap<String, Types> getVariables() {
        return variables;
    }

    public Types checkVariableDeclaration(Types variableType, Types expressionType) throws InvalidAssignmentException {
        if (expressionType == null) {
            return null;
        } else if (variableType.equals(Types.STRING) && expressionType.equals(Types.FLOAT) ||
                variableType.equals(Types.STRING) && expressionType.equals(Types.INT) ||
                variableType.equals(Types.INT) && expressionType.equals(Types.STRING) ||
                variableType.equals(Types.FLOAT) && expressionType.equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + expressionType.name() +
                    " a uma variável do tipo " + variableType.name());
        } else if (variableType.equals(expressionType)) {
            return variableType;
        } else if (variableType.equals(Types.FLOAT) || expressionType.equals(Types.FLOAT)) {
            return Types.FLOAT;
        } else {
            return Types.INT;
        }
    }

}
