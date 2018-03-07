package analysis.models;

public class Expression {

    private Types type;
    private Object value;
    private boolean isFromOperation;
    private String reg;

    public Expression(Types type, Object value) {
        this.type = type;
        this.value = value;
        this.isFromOperation = false;
    }

    public Expression(Types type, Object value, boolean isFromOperation) {
        this.type = type;
        this.value = value;
        this.isFromOperation = isFromOperation;
    }

    public Types getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public boolean isFromOperation() {
        return isFromOperation;
    }

    public void setFromOperation(boolean fromOperation) {
        isFromOperation = fromOperation;
    }

    public static Types getTypeOfNumber(String value) {
        if (value.contains(".")) {
            return Types.FLOAT;
        } else {
            return Types.INT;
        }
    }

    public static Object getValueOfNumber(String value) {
        if (value.contains(".")) {
            return Float.parseFloat(value);
        } else {
            return Integer.parseInt(value);
        }
    }

    public String getAssemblyValue() {
        return this.value.toString();
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    @Override
    public String toString() {
        return "TYPE: " + type + "VALUE: " + value;
    }
}
