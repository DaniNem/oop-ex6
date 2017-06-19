package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.Function;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Created by Admin on 15-Jun-17.
 */
public class DefinedMethodValidator implements Validator{
    private RamCollection localRam;
    private Function currentFunction;
    private String curLine;
    @Override
    public boolean isTriggered(String line) {
        String Prefix =  "[\\t\\s]*void[\\t\\s]*[A-Za-z][A-Za-z_\\d]*[\\t\\s]*\\([\\s\\t\\dA-Za-z_,]*\\)[\\s\\t]*(\\{[\\t\\s]*)$";
        if (line.matches(Prefix)){
            this.curLine = line;
            return true;
        }
        return false;
    }

    @Override
    public void setParams(RamCollection params) {
        this.localRam = params;

    }

    @Override
    public boolean doAction(Iterator<String> lines) throws Exception{
        String funcName = this.curLine.replaceAll("(void)|\\t|\\s*", "").replaceAll("\\(+.*","");
        Function curFunc = this.localRam.addFunction(funcName);
        curFunc.addCodeLine(this.curLine);
        /*String calledVars =curLine.replaceAll("^[a-zA-Z\\s]*+[(]", "")
                .replaceAll("[)]++[{]$", "");*/
        //String[] vars = curLine.split(",");
        Iterator<String> vars =
                new  ArrayList<String>(Arrays.asList(curLine.replaceAll("(.*[(])|([)].*)","").split(","))).iterator();


        //blockofcode working on making string to vars;


        RamCollection temp = new RamCollection();
        Validator validatorVars = new VariableDeclareEngine();
        validatorVars.setParams(temp);
        while (vars.hasNext()){
            String line  = vars.next().trim();
            if(!line.equals("")){
                line+=";";
                if(validatorVars.isTriggered(line)){
                    validatorVars.doAction(vars);}
                else throw new Exception("Cant tell the var type");
            }

        }
        //throw new Exception("Finish on this...");
        //curFunc.addVar();

        //Adding vars to the function object
        Iterator<Variable> funcVars = temp.getAllVariables();
        while (funcVars.hasNext()){
            Variable t =funcVars.next();
            t.setHasValue(true);
            curFunc.addVar(t);
        }


        int openSocpeCounter = 1;
        Validator close = new CloseBlockValidator();
        Validator open = new OpenBlockValidator();
        while(lines.hasNext()){
            String nextLine = lines.next();

            if(open.isTriggered(nextLine)){
                openSocpeCounter++;
            }
            else if (close.isTriggered(nextLine)){
                openSocpeCounter--;
                if (openSocpeCounter == 0){
                    curFunc.addCodeLine(nextLine);
                    return true;

                }
            }
            curFunc.addCodeLine(nextLine);
        }
        return true;
    }

    public DefinedMethodValidator clone(){
        return new DefinedMethodValidator();
    }
}
