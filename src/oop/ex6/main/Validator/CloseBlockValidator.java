package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by shani on 15/06/2017.
 */
public class CloseBlockValidator implements Validator {
    private String pattern = "\\s*\\}\\s*";
    private boolean isTriggered;
    private RamCollection localRam;

    public boolean isTriggered(String line){
        if (line.matches(pattern))
            return true;
        return false;
    }

    public void setParams(RamCollection params) {
        localRam = params;
    }


    public boolean doAction(Iterator<String> lines){
        if (isTriggered){
            // TDL add error if global scope
            localRam.closeScope();
            return true;
        }
        return false;
    }

    public Validator clone(){
        return new CloseBlockValidator();
    }
}
