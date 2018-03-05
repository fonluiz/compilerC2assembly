package analysis.models;

public class Variable {

    private Types type;
    private String name;

    public Variable(Types type, String name) {
        this.type = type;
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
