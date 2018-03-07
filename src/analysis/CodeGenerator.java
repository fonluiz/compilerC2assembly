package analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import analysis.exceptions.VariableNotInitializedException;
import analysis.models.*;

public class CodeGenerator {

    private int labels;
    private int register;
    private String assemblyCode;
    private Register[] registers;
    private HashMap<String, Register> variaveis = new HashMap<>();
    private String R = "R";
    private static int rnumber = -1;
    private Stack<IfScope> ifScopeStack = new Stack<>();
    private Stack<ElseScope> elseScopeStack = new Stack<>();

    private Map<String, Integer> functionAddress;

    public CodeGenerator() {
        this.labels = 100;
        this.register = -1;
        this.registers = Register.values();
        this.assemblyCode = initAssemblyCode();
        this.functionAddress = new HashMap<String, Integer>();
    }

    private String initAssemblyCode() {
        return "100: LD SP, #4000\n";
    }

    public void genCodeVariableDeclaration(Variable var) {
        labels+=8;
        String reg;
        if (var.getValor().getValue() != null) {
            if (var.getValor().getReg() == null) {
                reg =  var.getValor().getValue().toString();
            } else {
                reg = var.getValor().getReg().toString();
            }
            addCode(labels + ": ST " + var.getId() + ", " + reg);
        }
    }


    public void generateADDCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": ADD " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateSUBCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": SUB " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateMULCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": MUL " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateDIVCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": DIV " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateMODCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": MOD " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateANDCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": AND " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateORCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": OR " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateXORCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1 = getRegisterFromObject(obj1);

        String reg2 = getRegisterFromObject(obj2);

        labels += 8;
        addCode(labels + ": XOR " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateNOTCode(Object obj1, Expression exp) throws VariableNotInitializedException {
        String reg = getRegisterFromObject(obj1);

        labels += 8;
        addCode(labels + ": NOT " + exp.getReg() + ", " + reg);
    }


    public void codeForLoad(Variable v) {
        v.getValor().setReg(allocateRegister());
        Semantic.getInstance().addVariable(v);
        labels += 8;
        addCode(labels + ": LD " + v.getValor().getReg() +", "+ v.getId());
    }



    public void addCode(String assemblyString) {
        if (! ifScopeStack.empty()) {
            IfScope scope = ifScopeStack.pop();
            scope.code += assemblyString + "\n";
            ifScopeStack.push(scope);
        } else  if (! elseScopeStack.empty()) {
            ElseScope scope = elseScopeStack.pop();
            scope.code += assemblyString + "\n";
            elseScopeStack.push(scope);
        } else {
            if (assemblyString.substring(assemblyString.length() - 1).equals("\n")) {
                assemblyCode += assemblyString;
            } else {
                assemblyCode += assemblyString + "\n";
            }
        }
    }



    public String allocateRegister(){
        rnumber++;
        return R + rnumber;
    }


    public void generateFinalAssemblyCode() throws IOException {
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/";
        String sourcecode = rootPath + subPath + "generated-assembly.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(sourcecode)));

        writer.write(assemblyCode);
        writer.close();
    }



    public void generateBRCode(String s) {
        labels += 8;
        addCode(labels + ": BR " + s);
    }

    public void startIfScope(Object obj) {
        String reg = getRegisterFromObject(obj);
        labels += 8;
        ifScopeStack.push(new IfScope(reg, labels));
    }

    public void exitIfScope() {
        if (! ifScopeStack.empty()) {
            Integer fakelabel = labels + 8;
            addCode(ifScopeStack.pop().getCode(fakelabel));
        }
    }

    public void startElseScope() {
        labels += 8;
        elseScopeStack.push(new ElseScope(labels));
    }

    public void exitElseScope() {
        if (! elseScopeStack.empty()) {
            Integer fakelabel = labels + 8;
            addCode(elseScopeStack.pop().getCode(fakelabel));
        }
    }

    public String getRegisterFromObject(Object obj) {
        String reg1;
        if (obj instanceof Variable) {
            Variable var = (Variable) obj;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        return reg1;
    }

}
