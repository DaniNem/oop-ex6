package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class FunctionEngineValidator implements Validator{
    private ArrayList< Validator> simpleValidators;
    private RamCollection ram;

    public EngineValidartor(){
        simpleValidators.add(new AssignVariable());
        simpleValidators.add(new DeclareVaribleEngineValidator() );
        simpleValidators.add(new ReturnValidator());
        //What is end of line?
        //simpleValidators.add(new EndLineValidator());
        simpleValidators.add(new IfWhileValidator());
        simpleValidators.add(new OpenBlockValidator());
        simpleValidators.add(new CloseBlockValidator());

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
        while (lines.hasNext()){
            triggered = false;
            String line = lines.next();
            for (Validator v:this.simpleValidators){
                if (v.isTriggered(line)){
                    triggered = true;
                    v.doAction(lines);
                }
            }
            if (!triggered)return false;
        }
        return true;
    }