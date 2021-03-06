package analysis.models;

/**
 * Created by luiz on 07/03/18.
 */
public class IfScope {

    public String register;
    public Integer label;
    public String code;

    public IfScope(String register, Integer label) {
        this.register = register;
        this.label = label;
        this.code = "";
    }

    public String getCode(Integer currentLabel) {
        String actualCode =  label + ": BEQZ " + register + ", #" + currentLabel + "\n";
        actualCode += code;
        return actualCode;
    }

}
