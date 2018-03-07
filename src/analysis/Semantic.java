package analysis;

import analysis.exceptions.*;
import analysis.models.Function;
import analysis.models.Types;
import analysis.models.Variable;
import analysis.models.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Semantic {

    private static Semantic semantic = new Semantic();
    private static Semantic originalSemantic = semantic;
    private HashMap<String, Variable> variables = new HashMap<>();
    public static CodeGenerator codeGenerator = new CodeGenerator();
    private Variable tempForAssignment;
    private HashMap<String, Function> functions = new HashMap<>();
    private HashMap<String, Semantic> functionScopes = new HashMap<>();

    private Expression returnExp = null; // Gambiarra para analise semantica de funções
    public List<Expression> functionCallParams= new ArrayList<>();

    public Semantic() {

    }

    public static Semantic getInstance() {
        return semantic;
    }

    // FUNÇÕES
    public void addFunction(Function f) {
        functions.put(f.getId(), f);
    }

    public Function getFunctionById(String id) {
        return functions.get(id);
    }

    public void newScope() {
        semantic = new Semantic();
        String tempId = "tempID";
        functionScopes.put(tempId, semantic);
    }

    public void exitScope() {
        semantic = originalSemantic;
    }

    public void setScopeId(String id) {
        Semantic obj = functionScopes.remove("tempID");
        functionScopes.put(id, obj);
    }

    public Expression getReturnExp() {
        return returnExp;
    }

    public void setReturnExp(Expression returnExp) {
        this.returnExp = returnExp;
    }

    public void checkFunctionReturnType(Types declaredType, Types returnType) throws FunctionDefinitionException {

        if (declaredType.equals(Types.STRING) && returnType.equals(Types.FLOAT) ||
                declaredType.equals(Types.STRING) && returnType.equals(Types.INT) ||
                declaredType.equals(Types.INT) && returnType.equals(Types.STRING) ||
                declaredType.equals(Types.FLOAT) && returnType.equals(Types.STRING) ||
                declaredType.equals(Types.VOID) && ! returnType.equals(Types.STRING) ||
                ! declaredType.equals(Types.VOID) && returnType.equals(Types.VOID))  {
            throw new FunctionDefinitionException("O tipo de retorno da função (" + returnType.name() +") é incompatível" +
                    "com o tipo declarado da função ("+ declaredType.name() + ").");
        }
    }

    public HashMap<String, Function> getFunctions() {
        return functions;
    }

    public void checkFunctionCallParams(Object obj) throws InvalidParametersException, FunctionDefinitionException {

        if (obj instanceof Variable) {
            Variable v = (Variable) obj;
            Function f = originalSemantic.getFunctionById(v.getId());
            if (f != null) {
                if (f.getParams().size() != functionCallParams.size()) {
                    throw new InvalidParametersException("A função " + v.getId() + " recebe " +
                            f.getParams().size() + " parâmetros e você a chamou passando " + functionCallParams.size() +
                    " parâmetros");
                }

                for (int i = 0; i < functionCallParams.size(); i++) {
                    if (! f.getParams().get(i).getType().equals(functionCallParams.get(i).getType())) {
                        String params = v.getId() + "(";
                        for (int j = 0; j < functionCallParams.size(); j++) {
                            params += functionCallParams.get(i).getType().name() + ",";
                        }
                        params = params.substring(0, params.length() - 1) + ")";
                        throw new InvalidParametersException("A função " + v.getId() + "não é aplicável para os parâmetros " +
                        params + '.');
                    }
                }
            } else {
                throw new FunctionDefinitionException("A função " + v.getId() + " não foi definida");
            }
        }

    }

    // DECLARAÇÕES E ATRIBUIÇÕES
    public void addVariable(Variable v) {
        variables.put(v.getId(), v) ;
    }

    public void addVariables(List<Variable> vars) {
        for (Variable v : vars) {
            addVariable(v);
        }
    }

    public HashMap<String, Variable> getVariables() {
        return variables;
    }

    public Variable getVariableById(String id) {
        return variables.get(id);
    }

    public static CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void createTempForAssignment(Variable v) {
        tempForAssignment = v;
    }

    public boolean isTempForAssignment(Variable v) {
        if (tempForAssignment != null ){
            return tempForAssignment.getId().equals(v.getId());
        }
        return false;
    }

    public void destroyTempForAssignment() {
        tempForAssignment = null;
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

    public void checkAssignment(Object obj) throws VariableNotInitializedException {
        if (obj instanceof Variable) {
            Variable v = (Variable) obj;
            if (! v.isDeclared()) {
                throw new VariableNotInitializedException("A variável " + v.getId() + " não foi inicializada.");
            }
        }
    }

    public Expression execArithmeticExp(Object obj1, Object obj2, String operator) throws VariableNotInitializedException, InvalidArithmeticOperationException {

        Expression operand1 = getExpressionFromObject(obj1);
        Expression operand2 = getExpressionFromObject(obj2);

        Expression result = null;

        if (operand1.getType().equals(Types.STRING) || operand2.getType().equals(Types.STRING)) {
            throw new InvalidArithmeticOperationException("O operador '" + operator + "' não suporta operandos do tipo "
                    + operand1.getType().name() + " e " + operand2.getType().name());
        } else if (operand1.getType().equals(Types.FLOAT) || operand2.getType().equals(Types.FLOAT)) {
            result = arithmeticForFloat(operand1, operand2, operator);
        } else  {
            result = arithmeticForInt(operand1, operand2, operator);
        }

        return result;
    }

    public Expression getExpressionFromObject(Object obj) throws VariableNotInitializedException {
        Expression exp = null;
        if (obj instanceof Expression) {
            exp = (Expression) obj;
        } else if (obj instanceof Variable) {
            Variable var = (Variable) obj;
            Function f1 = functions.get(var.getId());
            if (f1 != null) {
                return f1.getReturnExp();
            } else {
                Function f2 = originalSemantic.getFunctionById(var.getId());
                if (f2 != null) {
                    return f2.getReturnExp();
                }
            }
            if (isTempForAssignment(var)) {
                var = tempForAssignment;
            } else if (! var.isDeclared()) {
                throw new VariableNotInitializedException("A variável " + var.getId() + " não foi inicializada.");
            }
            exp = var.toExpression();
        }
        return exp;
    }

    private Expression arithmeticForInt(Expression operand1, Expression operand2, String operator) {
        // Para o caso de serem parâmetros de uma função
        if (operand1.getValue() == null || operand2.getValue() == null) {
            return new Expression(Types.INT, null);
        }
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
        // Para o caso de serem parâmetros de uma função
        if (operand1.getValue() == null || operand2.getValue() == null) {
            return new Expression(Types.FLOAT, null);
        }
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

    // OPERAÇÕES BOOLEANAS
    public Expression execBooleanExp(Object obj1, Object obj2, String operator) throws InvalidBooleanOpException, VariableNotInitializedException {

        Expression operand1 = getExpressionFromObject(obj1);
        Expression operand2 = getExpressionFromObject(obj2);

        Expression result = null;

        // Para o caso de serem parâmetros de uma função
        if (operand1.getValue() == null || operand2.getValue() == null) {
            return new Expression(Types.INT, null);
        }

        if ((! operand1.getType().equals(Types.INT)) || (! operand2.getType().equals(Types.INT))) {
            throw new InvalidBooleanOpException("O operador '" + operator + "' não suporta operandos do tipo "
                    + operand1.getType().name() + " e " + operand2.getType().name());
        } else {
            switch (operator) {
                case ("&"):
                    if ((Integer) operand1.getValue() != 0 && (Integer) operand1.getValue() != 0) {
                        result = new Expression(Types.INT, 1);
                    } else {
                        result = new Expression(Types.INT, 0);
                    }
                    break;
                case ("&&"):
                    if ((Integer) operand1.getValue() != 0 && (Integer) operand1.getValue() != 0) {
                        result = new Expression(Types.INT, 1);
                    } else {
                        result = new Expression(Types.INT, 0);
                    }
                    break;
                case ("|"):
                    if ((Integer) operand1.getValue() != 0 || (Integer) operand1.getValue() != 0) {
                        result = new Expression(Types.INT, 1);
                    } else {
                        result = new Expression(Types.INT, 0);
                    }
                    break;
                case ("||"):
                    if ((Integer) operand1.getValue() != 0 || (Integer) operand1.getValue() != 0) {
                        result = new Expression(Types.INT, 1);
                    } else {
                        result = new Expression(Types.INT, 0);
                    }
                    break;
                case ("^"):
                    if (((Integer) operand1.getValue() != 0 && (Integer) operand1.getValue() == 0) ||
                            ((Integer) operand1.getValue() == 0 && (Integer) operand1.getValue() != 0)   ) {
                        result = new Expression(Types.INT, 1);
                    } else {
                        result = new Expression(Types.INT, 0);
                    }
                    break;
            }
        }

        return result;
    }

    public void checkIfCondition(Object obj) throws InvalidIfConditionException, VariableNotInitializedException {

        Expression exp = getExpressionFromObject(obj);

        if (! exp.getType().equals(Types.INT)) {
            throw new InvalidIfConditionException("A expressão do comando if não pode ser do tipo " + exp.getType().name());
        }
    }

}
