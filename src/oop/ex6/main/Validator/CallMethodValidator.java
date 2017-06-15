package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class CallMethodValidator implements Validator{
    private RamCollection localRam;
    public CallMethodValidator clone(){
        return new CallMethodValidator();
    }
    public void setParams(RamCollection ram){
        localRam = ram;
    }
    public Collection<ValidatorResult> doAction(Iterator<String> lines){
        ArrayList<ValidatorResult> retVal = new ArrayList<ValidatorResult>();
        //go To next line
        lines.next();
        return retVal;
    }
    public boolean isTriggered(String line){
        return true;
    }
}

