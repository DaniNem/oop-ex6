package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class IfWhileValidator implements Validator{
    String curLine;
    RamCollection localRam;
    @Override
    public boolean isTriggered(String line) {
        curLine = line;
        String pattern  = "^(if|while)+\\s*+\\(+[\\w\\s]+\\)+\\s*+\\{$";
        return line.matches(pattern);
    }

    @Override
    public void setParams(RamCollection params) {
        this.localRam = params;
    }

    @Override
    public boolean doAction(Iterator<String> lines) {
        String condition = this.curLine.replaceAll("^(if|while)+\\s*+\\(", "").replaceAll("\\)+\\s*+\\{","");
        String calledVars =curLine.replaceAll("^[a-zA-Z\\s]*+[(]", "")
                .replaceAll("[)]+[{]$", "");
        String[] vars = curLine.split("[\\s.]*(\\|\\|)|(&&)[\\s.]*");
        //TODO Empty? is it valid
        for (String str: vars
             ) {
            String cond = str.replaceAll("\\s*","");
            if (this.localRam.hasVariable(cond))
                {
                    //if more code needed
                    continue;
                }
            else {
                if (cond .equals("true")  || cond .equals("false") ){
                    //if more code needed
                    continue;
                }
                else {
                    if(AssignVariableValidator.getType(cond)!=null){
                        continue;
                    }
                    //this means youve got to error
                    return false;
                }
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
