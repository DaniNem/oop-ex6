package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.Iterator;

/**
 * Created by shani on 16/06/2017.
 */
public abstract class DeclareVariableValidator implements Validator {
    protected boolean isFinal;
    private RamCollection ram;
    private String curLine;
    private String finalPattern = "final";
    private String pattern = finalPattern+"?";
    private EndLineValidator endLine = new EndLineValidator();
    private AssignVariableValidator assignVariable = new AssignVariableValidator();
    private Validator EOL = new EndLineValidator();
    private Iterator<String> lines;


    public boolean isTriggered(String line){
        if (line.matches(getPattern())){
            curLine = line.replaceFirst("^\\s","").replaceFirst("\\s$","");//.replaceFirst(";$","");
            //curLine = curLine
            return true;
        }
        return false;
    }

    public void setParams(RamCollection params){
        this.ram = params;
    }

    public boolean doAction(Iterator<String> lines) throws Exception {
        this.lines = lines;

        if(!this.EOL.isTriggered(this.curLine))throw new Exception("No ;");
        else {this.curLine = this.curLine.replaceAll((";$"),"");}


        isFinal = false;
        if (curLine.startsWith(finalPattern)) {
            isFinal = true;
            curLine = curLine.replace(finalPattern, "");
        }
        if (curLine.matches(getPattern())) {
            curLine = curLine.replaceAll(getPatternA(), "");

            String[] param = curLine.split(",");
            for (String i : param){
                declare(i);
            }

            return true;
        }
        throw new Exception("Faild to Assign param");
    }

    private boolean declare(String param) throws Exception {
        String pattern = "\\s*[A-Za-z_]+[A-Za-z_\\d]*\\s*";
        param = param.replaceAll("^(\\s)||(\\s)$*","");
        String name = param.split("=")[0].replaceAll("^(\\s)*|(\\s)$*","");
        String value = "";
        if (param.length()>2) value = param.split("=")[1].replaceAll("^(\\s)*|(\\s)$*","");
        if (!this.ram.hasVariable(name) ) {

            if (param.matches(pattern) && !isFinal) {
                this.ram.addVariable(name, getType(), isFinal);
                return true;
            } else if (assignVariable.isTriggered(name+"="+value+";")) {

                Variable var = this.ram.addVariable(name, getType(), false);
                assignVariable.setParams(this.ram);
                assignVariable.doAction(this.lines);
                var.setFinal(isFinal);
                return true;
            }
        }
        throw new Exception("Error in Declartioxn");
    }

    protected abstract String getType();

    protected abstract String getPattern();
    protected abstract String getPatternA();

}


