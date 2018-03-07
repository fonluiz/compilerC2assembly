package analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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
        if (var.getValor().getReg() == null) {
            reg =  var.getValor().getValue().toString();
        } else {
            reg = var.getValor().getReg().toString();
        }
        addCode(labels + ": ST " + var.getId() + ", " + reg);
    }


    public void generateADDCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": ADD " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateSUBCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": SUB " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateMULCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": MUL " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateDIVCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": DIV " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateMODCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": MOD " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateANDCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": AND " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateORCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": OR " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }

    public void generateXORCode(Object obj1, Object obj2, Expression exp) throws VariableNotInitializedException {
        String reg1;
        if (obj1 instanceof Variable) {
            Variable var = (Variable) obj1;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg1 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj1;
            if (temp.getReg() == null) {
                reg1 = temp.getValue().toString();
            } else {
                reg1 = temp.getReg();
            }
        }

        String reg2;
        if (obj2 instanceof Variable) {
            Variable var = (Variable) obj2;
            codeForLoad(var);
            var = Semantic.getInstance().getVariableById(var.getId());
            reg2 = var.getValor().getReg();
        } else {
            Expression temp = (Expression) obj2;
            if (temp.getReg() == null) {
                reg2 = temp.getValue().toString();
            } else {
                reg2 = temp.getReg();
            }
        }

        labels += 8;
        addCode(labels + ": XOR " + exp.getReg() + ", " + reg1 + ", " + reg2);
    }



    public void codeForLoad(Variable v) {
        v.getValor().setReg(allocateRegister());
        Semantic.getInstance().addVariable(v);
        labels += 8;
        addCode(labels + ": LD " + v.getValor().getReg() +", "+ v.getId());
    }



    public void generateSUBCode(Register result, Register one, Expression exp) {
        labels += 8;
        addCode(labels + ": SUB " + result + ", " + one + ", #" + exp.getAssemblyValue());
    }


    public void generateSUBCode(Register result, Register one, String cons) {
        labels += 8;
        addCode(labels + ": SUB " + result + ", " + one + ", " + cons);
    }


    public void generateSTCode(Variable variable, Object obj) {
        labels += 8;
        addCode(labels + ": ST " + variable.getId() + ", #" + ((Expression) obj).getValue());
        //this.register = -1;
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

    public String allocateRegister(){
        rnumber++;
        return R + rnumber;
    }

    public int getLabels(){
        return labels;
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

}
