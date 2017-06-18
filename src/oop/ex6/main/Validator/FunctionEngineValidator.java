package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class FunctionEngineValidator implements Validator {
    private ArrayList<Validator> simpleValidators;
    private RamCollection ram;
    private Validator closed;
    private Validator ret;

    public FunctionEngineValidator clone(){
        return null;
    }
    public FunctionEngineValidator() {
        this.simpleValidators = new ArrayList< Validator>();
        this.simpleValidators.add(new AssignVariableValidator());
        this.simpleValidators.add(new VariableDeclareEngine());
        //simpleValidators.add(new ReturnValidator());
        //What is end of line?
        //simpleValidators.add(new EndLineValidator());
        this.simpleValidators.add(new IfWhileValidator());
        this.simpleValidators.add(new OpenBlockValidator());
        //simpleValidators.add(new CloseBlockValidator());

        // They must be special, this is what unique in functions...
        this.closed = new CloseBlockValidator();
        this.ret = new ReturnValidator();


    }

    @Override
    public boolean isTriggered(String line) {
        return true;
    }

    @Override
    public void setParams(RamCollection params) {
        this.ram = params;

    }

    @Override
    public boolean doAction(Iterator<String> lines) {
        boolean triggered;
        boolean retFlag = false;
        while (lines.hasNext()) {
            triggered = false;
            String line = lines.next();
            for (Validator v : this.simpleValidators) {
                if (v.isTriggered(line)) {
                    v.setParams(this.ram);
                    triggered = true;
                    v.doAction(lines);
                    break;
                }
            }
            if (closed.isTriggered(line)){
                triggered = true;
                if(!retFlag){
                    //TODO exception!!!
                    //throw new Exception("Must Have return!!");
                    return false;
                }
                closed.setParams(this.ram);
                closed.doAction(lines);

            }
            if (ret.isTriggered(line)){
                retFlag = true;
                ret.setParams(this.ram);
                ret.doAction(lines);
                triggered = true;
            }
            else retFlag = false;

            if (!triggered) return false;
        }
        return true;
    }
}