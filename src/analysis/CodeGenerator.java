package analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import analysis.models.*;

public class CodeGenerator {

    private int labels;
    private int register;
    private String assemblyCode;
    private Register[] registers;

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

    public void assignmentDeclaration(Variable var, Object obj) {
        if (obj instanceof Expression) {
            generateSTCode(var);
        }
//        if (obj instanceof Method) {
//            Method f = (Method) obj;
//            generateLDCode(new Expression(f.getName()));
//            generateSTCode(var);
//        }
    }



    public void generateBolExpCode(String op) {
        labels += 8;
        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": " + op + " " + result + ", " + one + ", " + two);
    }




    public void generateADDCode() {
        labels += 8;
        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": ADD " + result + ", " + one + ", " + two);
    }

    public void generateADDCode(String cons) {
        labels += 8;
        Register one = registers[register];
        register++;
        Register result = allocateRegister();
        addCode(labels + ": ADD " + result + ", " + one + ", #" + cons);
    }

    public void generateADDCode(Register result, Register one, String cons) {
        labels += 8;
        addCode(labels + ": ADD " + result + ", " + one + ", " + cons);
    }

    public void generateADDCode(Register result, Register one, Expression exp) {
        labels += 8;
        addCode(labels + ": ADD " + result + ", " + one + ", #" + exp.getAssemblyValue());
    }

    public void generateSUBCode() {
        labels += 8;
        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": SUB " + result + ", " + one + ", " + two);
    }

    public void generateSUBCode(Register result, Register one, Expression exp) {
        labels += 8;
        addCode(labels + ": SUB " + result + ", " + one + ", #" + exp.getAssemblyValue());
    }

    public void generateSUBCode(String cons) {
        labels += 8;
        Register one = registers[register];
        register++;
        Register result = allocateRegister();
        addCode(labels + ": SUB " + result + ", " + one + ", #" + cons);
    }

    public void generateSUBCode(Register result, Register one, String cons) {
        labels += 8;
        addCode(labels + ": SUB " + result + ", " + one + ", " + cons);
    }

    public void generateMULCode() {
        labels += 8;

        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": MUL " + result + ", " + one + ", " + two);
    }

    public void generateDIVCode() {
        labels += 8;

        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": DIV " + result + ", " + one + ", " + two);
    }

    public void generateMULCode(Register result, Register one, Expression exp) {
        labels += 8;
        addCode(labels + ": MUL " + result + ", " + one + ", #" + exp.getValue());
    }


    public void generateBEQCode(int br) {
        labels += 8;
        Register r1 = registers[register-1];
        Register r2 = allocateRegister();

        int jump = (br * 8) + labels;

        addCode(labels + ": BEQ " + r1 + ", " + r2 + ", " + jump);
    }

    public void generateBNEQZCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;

        Register current = allocateRegister();
        addCode(labels + ": BNEQZ " + current + ", " + jump);
    }

    public void generateForCondition(String op, String jump){
        labels += 8;
        Register current = allocateRegister();
        addCode(labels + ": " +op + " " + current + ", " + jump);
    }

    public void generateBGEQZCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;

        Register current = allocateRegister();
        addCode(labels + ": BGEQZ " + current + ", " + jump);
    }

    public void generateBLEQZCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;

        Register current = allocateRegister();
        addCode(labels + ": BLEQZ " + current + ", " + jump);
    }

    public void generateBLTZCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;

        Register current = allocateRegister();
        addCode(labels + ": BLTZ " + current + ", " + jump);
    }

    public void generateBGTZCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;

        Register current = allocateRegister();
        addCode(labels + ": BGTZ " + current + ", " + jump);
    }

    public void generateBRCode(int br) {
        labels += 8;
        int jump = (br * 8) + labels;
        addCode(labels + ": BR " + jump);
    }

    public Register generateLDCode(Expression expression) {
        Register r = null;
        if ((expression.getAssemblyValue() != null) && (expression.getValue() != null)) {
            register++;
            labels += 8;
            r = allocateRegister();
            addCode(labels + ": LD " + r + ", #" + expression.getAssemblyValue());
        }
        return r;
    }

    public Register generateLDCode(Variable var) {

        Register r = null;
        if (var.getId() != null) {
            register++;
            labels += 8;
            r = allocateRegister();
            addCode(labels + ": LD " + r + ", " + var.getId());
        }
        return r;
    }

    public Register generateLDCode(Register r, Expression expression) {
        if ((expression.getAssemblyValue() != null) && (expression.getValue() != null)) {
            labels += 8;
            addCode(labels + ": LD " + r + ", #" + expression.getAssemblyValue());
        }
        return r;
    }

    public void generateSTCode(Variable variable) {
        labels += 8;
        addCode(labels + ": ST " + variable.getId() + ", " + allocateRegister());
        this.register = -1;
    }

    public void generateSTCode(Register one, Expression exp) {
        labels += 8;
        addCode(labels + ": ST " + one + ", " + exp.getAssemblyValue());
        this.register = -1;
    }

    public void generateSTCode(Expression exp) {
        labels += 8;
        addCode(labels + ": ST " + exp.getAssemblyValue() + ", " + allocateRegister());
        this.register = -1;
    }

    public void addCode(String assemblyString) {
        assemblyCode += assemblyString + "\n";
    }

    public void generateCallFunction(String functionName) {
        Expression blockSize = new Expression(Types.INT,"size");
        Integer addressFunction = functionAddress.get(functionName);

        generateADDCode(Register.SP, Register.SP, blockSize);

        int jump = (3 * 8) + labels;
        generateSTCode(Register._SP, new Expression(Types.INT, Integer.toString(jump)));
        generateBRCode(addressFunction);
        generateSUBCode(Register._SP, Register.SP, blockSize);
    }

    public void generateBRCode(Integer address) {
        labels += 8;
        addCode(labels + ": BR " + address);
    }

    public void generateBRCode(Register register) {
        labels += 8;
        addCode(labels + ": BR " + register);
    }

    public void generateHalt() {
        labels += 8;
        addCode(labels + ": halt");
    }

    public String getAssemblyCode() {
        return assemblyCode;
    }

    public void setAssemblyCode(String assemblyCode) {
        this.assemblyCode = assemblyCode;
    }

    public void addFunctionAddress(String name) {
        labels = (labels +100)/100 * 100 - 8;
        functionAddress.put(name.trim(), labels+8);
        addCode("\n");
    }

    public void addBRSP(String funcname) {
        if(funcname.equals("main")){
            generateHalt();
        }else{
            labels += 8;
            addCode(labels+": BR *0(SP)");
        }

    }

    public void generateCodeFunctionCall(String name){


        Integer addressfuction = functionAddress.get(name);


        generateADDCode(Register.SP, Register.SP, "#"+name+"size");
        generateSTCode(Register.SP0, new Expression(Types.INT, "#"+(labels+24)));
        generateBRCode(addressfuction);
        generateSUBCode(Register.SP, Register.SP, "#"+name+"size");
    }

    public void generateCodeFunctionCall(String name, ArrayList<Expression> args){

        String key = name + " ";
        for (Expression e: args
                ) {
            key += e.getType().name();
        }
        Integer addressfuction = functionAddress.get(key);

        generateADDCode(Register.SP, Register.SP, "#"+name+"size");
        generateSTCode(Register.SP0, new Expression(Types.INT, "#"+(labels+24)));

        generateBRCode(addressfuction);
        generateSUBCode(Register.SP, Register.SP, "#"+name+"size");
    }


    public Register allocateRegister(){
        try {
            Register allocated = registers[register];
            return allocated;
        } catch (Exception e) {
            register++;
            return allocateRegister();
        }
    }

    public int getLabels(){
        return labels;
    }

    public void generateFinalAssemblyCode() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("generated-assembly.txt")));
        writer.write(assemblyCode);
        writer.close();
    }

    public void generateMODCode() {
        labels += 8;
        Register one = registers[register - 1];
        Register two = allocateRegister();

        register++;
        Register result = allocateRegister();
        addCode(labels + ": MOD " + result + ", " + one + ", " + two);
    }

    public void generateBRCode(String s) {
        labels += 8;
        addCode(labels + ": BR " + s);
    }

}
