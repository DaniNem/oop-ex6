package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.Function;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;

/**
 * Created by Admin on 15-Jun-17.
 */
public class CallMethodValidator implements Validator{
    private RamCollection localRam;
    private Function currentFunction;
    private String curLine;
    public CallMethodValidator clone(){
        CallMethodValidator retVal =  new CallMethodValidator();
        retVal.localRam = this.localRam;
        retVal.currentFunction = this.currentFunction;
        retVal.curLine = this.curLine;
        return retVal;
    }
    public void setParams(RamCollection ram){
        this.localRam = ram;
    }
    public boolean doAction(Iterator<String> lines) {
        String calledVars = curLine.replace("^[a-zA-Z]*+[(]", "")
                .replace(");", "");
        String[] vars = curLine.split(",");
        Variable[] FunctionVarables =  currentFunction.getVars().
                toArray(new Variable[ currentFunction.getVars().size()]);
        //error!!!
        if (FunctionVarables.length != vars.length) return false;
        for (int i = 0; i < FunctionVarables.length; i++) {
            // in case this in the ram
            if (localRam.hasVariable(vars[i]))
                if( AssignVariableValidator.isType(localRam.getVariable(vars[i]).getType() , FunctionVarables[i].getType())){
                //good stuff
                }
                else {
                    //bad stuff
                    return false;
                }
            else {

                if(AssignVariableValidator.isType(AssignVariableValidator.getType(vars[i]),FunctionVarables[i].getType())){
                    //good suff
                }
                else {
                    //bad stuff
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isTriggered(String line){
        ArrayList<String> patterns = new ArrayList<String>();
        for (Iterator<Function> iter = this.localRam.getAllFunction(); iter.hasNext();) {
            Function cur = iter.next();
            if (line.matches("^"+cur.getName())){
                currentFunction = cur;
                curLine = line;
                return true;
            }

        }
        return false;
    }
}

