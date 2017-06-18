package oop.ex6.main.Validator;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.Iterator;

/**
 * Created by shani on 15/06/2017.
 */
public class AssignVariableValidator implements Validator {
    private String curLine;
    private RamCollection ram;

    private final String pattern = "\\s*[a-zA-Z_][a-zA-Z_\\d]*\\s*=\\s*[^\\s]+\\s*";
    private EndLineValidator endLine = new EndLineValidator();

    public boolean isTriggered(String line){
        if (line.contains(pattern)){
            curLine = line;
            return true;
        }
        return false;
    }
    public void setParams(RamCollection params){
        ram = params;
    }

    public boolean doAction(Iterator<String> lines){
        if (endLine.isTriggered(curLine)) {
            String[] param = curLine.split("\\s*=\\s*",2);
            if (ram.hasVariable(param[0])) {
                Variable var = ram.getVariable(param[0]);
                if (!var.isFinal()) {
                    if (ram.hasVariable(param[1])) {
                        Variable assignedVal = ram.getVariable(param[1]);
                        if (var.getType().equals(assignedVal.getType())) {
                            return true;
                        }
                    } else if (param[1].matches(var.getType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Validator clone(){
        return new AssignVariableValidator();
    }

}
