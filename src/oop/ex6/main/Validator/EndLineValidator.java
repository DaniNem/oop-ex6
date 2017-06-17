package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by shani on 16/06/2017.
 */
public class EndLineValidator implements Validator {
    private String pattern = "\\s*;\\s*$";
    private boolean isTriggered = false;


    public boolean isTriggered(String line) {
        if (line.matches(pattern)) {
            isTriggered = true;
            return true;
        }
        return false;
    }

    public void setParams(RamCollection params){
    }

    public boolean doAction(Iterator<String> lines){
        return isTriggered;
    }

    public Validator clone(){
        return new EndLineValidator();
    }

}
