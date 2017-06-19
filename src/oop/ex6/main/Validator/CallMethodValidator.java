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
    private Validator EOL;

    public CallMethodValidator(){
        this.EOL = new EndLineValidator();
    }

    public void setParams(RamCollection ram){
        this.localRam = ram;
    }

    public boolean doAction(Iterator<String> lines) throws Exception {
        if(!this.EOL.isTriggered(this.curLine))throw new Exception("No ;");
        else {this.curLine = this.curLine.replaceAll((";$"),"");}
        String calledVars = curLine.replaceAll(".*\\(", "")
                .replaceAll("\\)+[.]*", "");
        String[] vars;
        if (!calledVars.equals(""))vars = calledVars.split(",");
        else vars = new String[0];

        Variable[] FunctionVarables =  currentFunction.getVars().
                toArray(new Variable[ currentFunction.getVars().size()]);
        //error!!!
        if (FunctionVarables.length != vars.length) throw new Exception("The num of parameters are not good");
        for (int i = 0; i < FunctionVarables.length; i++) {

            // in case this in the ram
            if (localRam.hasVariable(vars[i].trim())) {
                if (!localRam.getVariable(vars[i]).getType().equals(FunctionVarables[i].getType()))
                    throw new Exception("Bad type kaki!!");
            }else {
                if(!vars[i].trim().matches(FunctionVarables[i].getType()))throw new Exception("Bad type kaki!!");
            }
        }
        return true;
    }
    public boolean isTriggered(String line){
        //line = line.replaceFirst(";","");
        ArrayList<String> patterns = new ArrayList<String>();
        for (Iterator<Function> iter = this.localRam.getAllFunction(); iter.hasNext();) {
            Function cur = iter.next();
            //System.out.println(line.replaceAll("[\\s\\t]*",""));
            //System.out.println(line.trim());
            if (line.replaceAll("[\\s\\t]*","").matches("^"+cur.getName()+"\\(.*\\);")){
                currentFunction = cur;
                curLine = line;
                return true;
            }

        }
        return false;
    }
}

   /* public CallMethodValidator clone(){
        CallMethodValidator retVal =  new CallMethodValidator();
        retVal.localRam = this.localRam;
        retVal.currentFunction = this.currentFunction;
        retVal.curLine = this.curLine;
        return retVal;
    }*/