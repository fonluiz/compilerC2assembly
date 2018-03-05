package analysis;

import analysis.exceptions.InvalidAssignmentException;
import analysis.exceptions.InvalidBooleanOpException;
import analysis.models.Types;
import analysis.models.Variable;
import analysis.models.Expression;

import java.util.HashMap;

public class Semantic {

    private static Semantic semantic = new Semantic();
    private HashMap<String, Variable> variables = new HashMap<>();

    private Semantic() {}

    public static Semantic getInstance() {
        return semantic;
    }

    // DECLARAÇÕES E ATRIBUIÇÕES
    public void addVariable(Variable v) {
        variables.put(v.getId(), v) ;
    }

    public HashMap<String, Variable> getVariables() {
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

    public Expression checkAddCompatibility(Expression e1, Expression e2) throws InvalidAssignmentException {
        if (e1.getType().equals(Types.STRING) && e2.getType().equals(Types.FLOAT) ||
                e1.getType().equals(Types.STRING) && e2.getType().equals(Types.INT) ||
                e1.getType().equals(Types.INT) && e2.getType().equals(Types.STRING) ||
                e1.getType().equals(Types.FLOAT) && e2.getType().equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + e1.getType().name() +
                    " a uma variável do tipo " + e2.getType().name());
        } else if (e1.getType().equals(e2.getType())) {
            if(e1.getValue() instanceof String){
                throw new InvalidAssignmentException("Operação inválida"); // Ajeitar exception
            } else if (e1.getValue() instanceof Float){
                Float f = (Float) e1.getValue() + (Float) e2.getValue();
                return new Expression(Types.FLOAT, (Object) f);
            } else {
                Integer i = (Integer) e1.getValue() + (Integer) e2.getValue();
                return new Expression(Types.INT, (Object) i);
            }
        } else if (e1.getType().equals(Types.FLOAT) || e2.getType().equals(Types.FLOAT)) {
            Float f = (Float) e1.getValue() + (Float) e2.getValue();
            return new Expression(Types.FLOAT, (Object) f);
        } else {
            Integer i = (Integer) e1.getValue() + (Integer) e2.getValue();
            return new Expression(Types.INT, (Object) i);
        }
    }

    public Expression checkSubCompatibility(Expression e1, Expression e2) throws InvalidAssignmentException {
        if (e1.getType().equals(Types.STRING) && e2.getType().equals(Types.FLOAT) ||
                e1.getType().equals(Types.STRING) && e2.getType().equals(Types.INT) ||
                e1.getType().equals(Types.INT) && e2.getType().equals(Types.STRING) ||
                e1.getType().equals(Types.FLOAT) && e2.getType().equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + e1.getType().name() +
                    " a uma variável do tipo " + e2.getType().name());
        } else if (e1.getType().equals(e2.getType())) {
            if(e1.getValue() instanceof String){
                throw new InvalidAssignmentException("Operação inválida");
            } else if (e1.getValue() instanceof Float){
                Float f = (Float) e1.getValue() - (Float) e2.getValue();
                return new Expression(Types.FLOAT, (Object) f);
            } else {
                Integer i = (Integer) e1.getValue() - (Integer) e2.getValue();
                return new Expression(Types.INT, (Object) i);
            }
        } else if (e1.getType().equals(Types.FLOAT) || e2.getType().equals(Types.FLOAT)) {
            Float f = (Float) e1.getValue() - (Float) e2.getValue();
            return new Expression(Types.FLOAT, (Object) f);
        } else {
            Integer i = (Integer) e1.getValue() - (Integer) e2.getValue();
            return new Expression(Types.INT, (Object) i);
        }
    }

    public Expression checkMulCompatibility(Expression e1, Expression e2) throws InvalidAssignmentException {
        System.out.println(e1.getType());
        System.out.println(e2.getType());
        if (e1.getType().equals(Types.STRING) && e2.getType().equals(Types.FLOAT) ||
                e1.getType().equals(Types.STRING) && e2.getType().equals(Types.INT) ||
                e1.getType().equals(Types.INT) && e2.getType().equals(Types.STRING) ||
                e1.getType().equals(Types.FLOAT) && e2.getType().equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + e1.getType().name() +
                    " a uma variável do tipo " + e2.getType().name());
        } else if (e1.getType().equals(e2.getType())) {
            if(e1.getValue() instanceof String){
                throw new InvalidAssignmentException("Operação inválida");
            } else if (e1.getValue() instanceof Float){
                Float f = (Float) e1.getValue() * (Float) e2.getValue();
                return new Expression(Types.FLOAT, (Object) f);
            } else {
                Integer i = (Integer) e1.getValue() * (Integer) e2.getValue();
                return new Expression(Types.INT, (Object) i);
            }
        } else if (e1.getType().equals(Types.FLOAT) || e2.getType().equals(Types.FLOAT)) {
            Float f = (Float) e1.getValue() * (Float) e2.getValue();
            return new Expression(Types.FLOAT, (Object) f);
        } else {
            Integer i = (Integer) e1.getValue() * (Integer) e2.getValue();
            return new Expression(Types.INT, (Object) i);
        }
    }

    public Expression checkDivideCompatibility(Expression e1, Expression e2) throws InvalidAssignmentException {
        if (e1.getType().equals(Types.STRING) && e2.getType().equals(Types.FLOAT) ||
                e1.getType().equals(Types.STRING) && e2.getType().equals(Types.INT) ||
                e1.getType().equals(Types.INT) && e2.getType().equals(Types.STRING) ||
                e1.getType().equals(Types.FLOAT) && e2.getType().equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + e1.getType().name() +
                    " a uma variável do tipo " + e2.getType().name());
        } else if (e1.getType().equals(e2.getType())) {
            if(e1.getValue() instanceof String){
                throw new InvalidAssignmentException("Operação inválida");
            } else if (e1.getValue() instanceof Float){
                Float f = (Float) e1.getValue() / (Float) e2.getValue();
                return new Expression(Types.FLOAT, (Object) f);
            } else {
                Integer i = (Integer) e1.getValue() / (Integer) e2.getValue();
                return new Expression(Types.INT, (Object) i);
            }
        } else if (e1.getType().equals(Types.FLOAT) || e2.getType().equals(Types.FLOAT)) {
            Float f = (Float) e1.getValue() / (Float) e2.getValue();
            return new Expression(Types.FLOAT, (Object) f);
        } else {
            Integer i = (Integer) e1.getValue() / (Integer) e2.getValue();
            return new Expression(Types.INT, (Object) i);
        }
    }

    public Expression checkModulusCompatibility(Expression e1, Expression e2) throws InvalidAssignmentException {
        if (e1.getType().equals(Types.STRING) && e2.getType().equals(Types.FLOAT) ||
                e1.getType().equals(Types.STRING) && e2.getType().equals(Types.INT) ||
                e1.getType().equals(Types.INT) && e2.getType().equals(Types.STRING) ||
                e1.getType().equals(Types.FLOAT) && e2.getType().equals(Types.STRING)) {
            throw new InvalidAssignmentException("Não é possível atribuir uma expressão do tipo " + e1.getType().name() +
                    " a uma variável do tipo " + e2.getType().name());
        } else if (e1.getType().equals(e2.getType())) {
            if (e1.getValue() instanceof String) {
                throw new InvalidAssignmentException("Operação inválida");
            } else if (e1.getValue() instanceof Float) {
                Float f = (Float) e1.getValue() % (Float) e2.getValue();
                return new Expression(Types.FLOAT, (Object) f);
            } else {
                Integer i = (Integer) e1.getValue() % (Integer) e2.getValue();
                return new Expression(Types.INT, (Object) i);
            }
        } else if (e1.getType().equals(Types.FLOAT) || e2.getType().equals(Types.FLOAT)) {
            Float f = (Float) e1.getValue() % (Float) e2.getValue();
            return new Expression(Types.FLOAT, (Object) f);
        } else {
            Integer i = (Integer) e1.getValue() % (Integer) e2.getValue();
            return new Expression(Types.INT, (Object) i);
        }
    }

    public Expression checkBooleanExp(Expression e1, Expression e2, Object op) throws InvalidBooleanOpException {
        Object e1Value, e2Value;
        if(e1.getType() == Types.STRING || e2.getType() == Types.STRING)
            throw new InvalidBooleanOpException("Operações inválidas entre o tipo " + Types.STRING.name());
        else if(e1.getType() == e2.getType()){
              if (e1.getValue() instanceof Float) {
                  e1Value = (Float) e1.getValue();
                  e2Value = (Float) e2.getValue();
            } else {
                  e1Value = (Integer) e1.getValue();
                  e2Value = (Integer) e2.getValue();
            }
        }

        String operand = op.toString();

        switch (operand){
            case "<":
                if(e1Value. < e2Value)
        }

        return null;
    }

}
