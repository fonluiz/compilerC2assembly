package analysis.models;

public class PrimaryExpression {

    private Types type;
    private Object value;

    public PrimaryExpression(Types type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Types getType() {
        return type;
    }

    public Object getValue() {
        return value;
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


}
