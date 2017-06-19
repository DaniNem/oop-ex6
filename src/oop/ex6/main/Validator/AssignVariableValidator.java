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
    private EndLineValidator EOL = new EndLineValidator();

    public boolean isTriggered(String line){
        if (line.matches(pattern)){
            curLine = line;
            return true;
        }
        return false;
    }
    public void setParams(RamCollection params){
        ram = params;
    }

    public boolean doAction(Iterator<String> lines) throws Exception {
        //if (endLine.isTriggered(curLine)) {
        if(!this.EOL.isTriggered(this.curLine))throw new Exception("No ;");
        else {this.curLine = this.curLine.replaceAll((";$"),"");}
        String[] param = curLine.split("\\s*=\\s*", 2);
        Variable var = null;
        if (ram.hasVariable(param[0])) {
            var = ram.getVariable(param[0]);

        } else if (ram.hasVariableGlobal(param[0])) {
            var = ram.getVariableGlobal(param[0]);
            if (!var.isHasValue())throw new Exception("You cant use global values before assigning value");

        }

        if (var != null && !var.isFinal()) {
            Variable assignedVal = null;

            if (ram.hasVariable(param[1])) {
                assignedVal = ram.getVariable(param[1]);
            } else if (ram.hasVariableGlobal(param[1])) {
                assignedVal = ram.getVariableGlobal(param[1]);
            }
            if (assignedVal != null) {
                if (!assignedVal.isHasValue()) throw new Exception("AssignVariableValidator");
                if (var.getType().equals(assignedVal.getType())) {
                    var.setHasValue(true);
                    return true;
                }
            } else if (param[1].matches(var.getType())) {
                var.setHasValue(true);
                return true;
            }
        }
        //}
        //return false;
        throw new Exception("AssignVariableValidator");
    }


    /*public Validator clone(){
        return new AssignVariableValidator();
    }*/

}
