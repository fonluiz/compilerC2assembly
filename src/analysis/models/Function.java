package analysis.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luiz on 06/03/18.
 */
public class Function {

    private String id;
    private Types declaredReturnType;
    private Expression returnExp;
    private List<Variable> params;

    public Function(String id, Types declaredReturnType, Expression returnExp, List<Variable> params) {
        this.id = id;
        this.declaredReturnType = declaredReturnType;
        this.returnExp = returnExp;
        this.params = params;
    }

    public Types getDeclaredReturnType() {
        return declaredReturnType;
    }

    public Types getReturnType() {
        if (returnExp == null || returnExp.getType() == null) {
            return Types.VOID;
        }
        return returnExp.getType();
    }

    public List<Variable> getParams() {
        if (params == null) {
            return new ArrayList<>();
        }
        return params;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeclaredReturnType(Types declaredReturnType) {
        this.declaredReturnType = declaredReturnType;
    }

    public void setReturnExp(Expression retexp) {
        this.returnExp = retexp;
    }

    public void setParams(List<Variable> params) {
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public Expression getReturnExp() {
        return returnExp;
    }
}
