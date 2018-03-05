package analysis;

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

    public void addVariable(Variable v) {
        variables.put(v.getName(), v.getType()) ;
    }

    public HashMap<String, Types> getVariables() {
        return variables;
    }
}
