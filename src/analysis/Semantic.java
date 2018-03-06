package analysis;

import analysis.exceptions.InvalidArithmeticOpException;
import analysis.exceptions.InvalidAssignmentException;
import analysis.exceptions.InvalidBooleanOpException;
import analysis.exceptions.InvalidIfElseOpException;
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

    public Variable getVariableById(String id) {
        return variables.get(id);
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

    public Expression execArithmeticExp(Object obj1, Object obj2, String operator) throws InvalidArithmeticOpException {
        Expression operand1 = getExpressionFromObject(obj1);
        Expression operand2 = getExpressionFromObject(obj2);

        System.out.println(operand1);
        System.out.println(operand1.getType());

        Expression result = null;

        if (operand1.getType().equals(Types.STRING) || operand2.getType().equals(Types.STRING)) {
            throw new InvalidArithmeticOpException("O operador '" + operator + "' não suporta operandos do tipo "
                    + operand1.getType().name() + " e " + operand2.getType().name());
        } else if (operand1.getType().equals(Types.FLOAT) || operand2.getType().equals(Types.FLOAT)) {
            result = arithmeticForFloat(operand1, operand2, operator);
        } else  {
            result = arithmeticForInt(operand1, operand2, operator);
        }

        return result;
    }

    private Expression getExpressionFromObject(Object obj) {
        Expression exp = null;
        if (obj instanceof Expression) {
            exp = (Expression) obj;
            System.out.println("rola");
        } else if (obj instanceof Variable) {
            System.out.println("cu");
            exp = ((Variable) obj).toExpression();
        }
        return exp;
    }

    private Expression arithmeticForInt(Expression operand1, Expression operand2, String operator) {
        Expression result = null;
        switch (operator) {
            case ("+"):
                Integer f1 = (Integer) operand1.getValue() + (Integer) operand2.getValue();
                result = new Expression(Types.FLOAT, f1);
                break;
            case ("-"):
                Integer f2 = (Integer) operand1.getValue() - (Integer) operand2.getValue();
                result = new Expression(Types.FLOAT, f2);
                break;
            case ("*"):
                Integer f3 = (Integer) operand1.getValue() * (Integer) operand2.getValue();
                result = new Expression(Types.FLOAT, f3);
                break;
            case ("/"):
                Integer f4 = (Integer) operand1.getValue() / (Integer) operand2.getValue();
                result = new Expression(Types.FLOAT, f4);
                break;
            case ("%"):
                Integer f5 = (Integer) operand1.getValue() % (Integer) operand2.getValue();
                result = new Expression(Types.FLOAT, f5);
                break;
        }
        return result;
    }

    private Expression arithmeticForFloat(Expression operand1, Expression operand2, String operator) {
        Expression result = null;
        switch (operator) {
            case ("+"):
                Float f1 = (Float) operand1.getValue() + (Float) operand2.getValue();
                result = new Expression(Types.FLOAT, f1);
                break;
            case ("-"):
                Float f2 = (Float) operand1.getValue() - (Float) operand2.getValue();
                result = new Expression(Types.FLOAT, f2);
                break;
            case ("*"):
                Float f3 = (Float) operand1.getValue() * (Float) operand2.getValue();
                result = new Expression(Types.FLOAT, f3);
                break;
            case ("/"):
                Float f4 = (Float) operand1.getValue() / (Float) operand2.getValue();
                result = new Expression(Types.FLOAT, f4);
                break;
            case ("%"):
                Float f5 = (Float) operand1.getValue() % (Float) operand2.getValue();
                result = new Expression(Types.FLOAT, f5);
                break;
        }
        return result;
    }

    public Expression execBooleanExp(Object obj1, Object obj2, String operator) throws InvalidBooleanOpException {
        Expression operand1 = getExpressionFromObject(obj1);
        Expression operand2 = getExpressionFromObject(obj2);

        Expression result = null;

        if (operand1.getType().equals(Types.STRING) || operand2.getType().equals(Types.STRING)) {
            throw new InvalidBooleanOpException("O operador '" + operator + "' não suporta operandos do tipo "
                    + operand1.getType().name() + " e " + operand2.getType().name());
        } else if (operand1.getType().equals(Types.FLOAT) || operand2.getType().equals(Types.FLOAT)) {
            result = booleanForFloat(operand1, operand2, operator);
        } else  {
            result = booleanForInt(operand1, operand2, operator);
        }

        return result;
    }

    private Expression booleanForInt(Expression operand1, Expression operand2, String operator) {
        Expression result = null;
        switch (operator) {
            case "<":
                Integer f1 = ((Integer) operand1.getValue() < (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f1);
                break;
            case ">":
                Integer f2 = ((Integer) operand1.getValue() > (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f2);
                break;
            case "<=":
                Integer f3 = ((Integer) operand1.getValue() <= (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f3);
                break;
            case ">=":
                Integer f4 = ((Integer) operand1.getValue() >= (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f4);
                break;
            case "==":
                Integer f5 = ((Integer) operand1.getValue() == (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f5);
                break;
            case "!=":
                Integer f6 = ((Integer) operand1.getValue() != (Integer) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.INT, f6);
                break;
        }
        return result;
    }

    private Expression booleanForFloat(Expression operand1, Expression operand2, String operator) {
        Expression result = null;
        switch (operator) {
            case "<":
                Integer f1 = ((Float) operand1.getValue() < (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f1);
                break;
            case ">":
                Integer f2 = ((Float) operand1.getValue() > (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f2);
                break;
            case "<=":
                Integer f3 = ((Float) operand1.getValue() <= (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f3);
                break;
            case ">=":
                Integer f4 = ((Float) operand1.getValue() >= (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f4);
                break;
            case "==":
                Integer f5 = ((Float) operand1.getValue() == (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f5);
                break;
            case "!=":
                Integer f6 = ((Float) operand1.getValue() != (Float) operand2.getValue()) ? 1 : 0;
                result = new Expression(Types.FLOAT, f6);
                break;
        }
        return result;
    }

    public Expression execIfElseExp(Object obj1) throws InvalidIfElseOpException {
        Expression operand1 = getExpressionFromObject(obj1);

        Expression result = null;

        if(operand1.getType() == Types.STRING){
            throw new InvalidIfElseOpException("Operação inválida para operandos do tipo "
                    + operand1.getType().name());
        }else if(operand1.getType() == Types.FLOAT){
            result = new Expression(Types.INT, ((Float) operand1.getValue()).intValue() );
        } else result = operand1;

        return result;
    }

}
