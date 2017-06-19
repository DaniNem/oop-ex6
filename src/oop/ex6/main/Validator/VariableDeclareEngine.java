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
    private String curLine;
    Validator trigValidator;
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
        this.curLine = line;
        for (Validator v : this.simpleValidators) {
            v.setParams(this.ram);
            if (v.isTriggered(line)) {
                this.trigValidator = v;
                return true;
            }
        }
        return false;
    }

    @Override
    public void setParams(RamCollection params) {
        this.ram = params;

    }

    @Override
    public boolean doAction(Iterator<String> lines) throws Exception{
        return this.trigValidator.doAction(lines);
    }
}