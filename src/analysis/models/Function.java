package analysis.models;

import java.util.List;

/**
 * Created by luiz on 06/03/18.
 */
public class Function {

    private String id;
    private Types declaredReturnType;
    private Types returnType;
    private List<Variable> params;
    private Object returnValue;

    public Function(String id, Types declaredReturnType, Types returnType, List<Variable> params) {
        this.id = id;
        this.declaredReturnType = declaredReturnType;
        this.returnType = returnType;
        this.params = params;
    }

    public Types getDeclaredReturnType() {
        return declaredReturnType;
    }

    public Types getReturnType() {
        return returnType;
    }

    public List<Variable> getParams() {
        return params;
    }

    public String getId() {
        return id;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }
}
