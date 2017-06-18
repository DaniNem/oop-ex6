package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 18-Jun-17.
 */
public class VariableDeclareEngine implements Validator {
    private ArrayList<Validator> simpleValidators;
    private RamCollection ram;
    public FunctionEngineValidator clone(){
        return null;
    }
    public VariableDeclareEngine() {
        this.simpleValidators = new ArrayList<Validator>();
        this.simpleValidators.add(new DeclareStringValidator());
        this.simpleValidators.add(new DeclareBooleanValidator());
        this.simpleValidators.add(new DeclareCharValidator());
        //What is end of line?
        //simpleValidators.add(new EndLineValidator());
        this.simpleValidators.add(new DeclareIntValidator());
        this.simpleValidators.add(new DeclareDoubleValidator());

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
        while (lines.hasNext()) {
            triggered = false;
            String line = lines.next();
            for (Validator v : this.simpleValidators) {
                if (v.isTriggered(line)) {
                    triggered = true;
                    v.doAction(lines);
                    break;
                }
            }
            if (!triggered) return false;
        }
        return true;
    }
}