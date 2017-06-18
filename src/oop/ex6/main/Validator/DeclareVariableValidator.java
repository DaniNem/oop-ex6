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
    private String finalPattern = "final\\s+";
    private String pattern = finalPattern+"?";
    private EndLineValidator endLine = new EndLineValidator();
    private AssignVariableValidator assignVariable = new AssignVariableValidator();
    private Iterator<String> lines;


    public boolean isTriggered(String line){
        if (line.startsWith(pattern+getPattern())){
            curLine = line.replaceFirst("\\s","");
            return true;
        }
        return false;
    }

    public void setParams(RamCollection params){
        ram = params;
    }

    public boolean doAction(Iterator<String> lines){
        this.lines = lines;
        if (endLine.isTriggered(curLine)) {
            isFinal = false;
            if (curLine.startsWith(finalPattern)) {
                isFinal = true;
                curLine.replace(finalPattern, "");
            }
            if (curLine.startsWith(getPattern())) {
                curLine.replace(getPattern(), "");
                String[] param = curLine.split(",");
                for (String i : param)
                    if (!declare(i))
                        return false;
                return true;
            }
        }
        return false;
    }

    private boolean declare(String param){
        String pattern = "\\s*[A-Aa-a_]+[A-Za-z_\\d]*\\s*";
        String name = param.replaceFirst("\\s*","").split("\\s")[0];

        if (!ram.hasVariable(name)) {
            if (param.matches(pattern)) {
                ram.addVariable(name, getType(), isFinal);
                return true;
            } else if (assignVariable.isTriggered(param)) {
                Variable var = ram.addVariable(name, getType(), false);
                assignVariable.setParams(ram);
                assignVariable.doAction(lines);
                var.setFinal(isFinal);
                return true;
            }
        }
        return false;
    }

    protected abstract String getType();

    protected abstract String getPattern();

}


