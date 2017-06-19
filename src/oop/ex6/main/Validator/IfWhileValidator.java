package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class IfWhileValidator implements Validator{
    private String curLine;
    private RamCollection localRam;
    private final String pattern  = "\\s*+(if|while)+.*";
    @Override
    public boolean isTriggered(String line) {
        curLine = line;
        return line.matches(this.pattern);
    }

    @Override
    public void setParams(RamCollection params) {
        this.localRam = params;
    }

    @Override
    public boolean doAction(Iterator<String> lines) throws Exception {

        String allowed = "(true)|(false)|(-?\\d+.\\d+)|(-?\\d)";
        //String condition = this.curLine.replaceAll("^(if|while)+\\s*+\\(", "").replaceAll("\\)+\\s*+\\{","");
        String calledVars = curLine.replaceAll(".*\\([\\t\\s]*", "")
                .replaceAll("[\\s\\t]*\\)[\\s\\t]*\\{[\\t\\s]*", "");
        String[] vars = calledVars.split("[\\s.]*(\\|\\|)|(&&)[\\s.]*");
        //TODO Empty? is it valid
        for (String str: vars) {
            String cond = str.trim();
            //this.localRam.addVariable("IFWHILE","(true)|(false)|(-?\\d+.\\d+)|(-?\\d)",false);
            //if(!AssignVariableValidator.TT("IFWHILE",cond,this.localRam))return false;
            if (this.localRam.hasVariable(cond)) {
                Variable var = localRam.getVariable(cond);
                if (!allowed.contains(var.getType()) || !var.isHasValue())throw new Exception("Error in if!!");
                }
            else  if (this.localRam.hasVariableGlobal(cond)) {
                Variable var = localRam.getVariableGlobal(cond);
                if (!allowed.contains(var.getType()))throw new Exception("Error in if!!");
            }
            else if (!cond.matches(allowed)) {
                throw new Exception("Error in if!!");
            }
        }
        this.localRam.openScope();
        return true;
    }

    @Override
    public Validator clone() {
        return null;
    }
}
