package analysis.models;

public class Variable {

    private Types type;
    private String id;
    private Expression valor;

    public Variable(Types type, String id, Expression valor) {
        this.type = type;
        this.id = id;
        this.valor = valor;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getValor() {
        return valor;
    }

    public void setValor(Expression valor) {
        this.valor = valor;
    }
}
