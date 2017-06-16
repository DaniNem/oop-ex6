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

    public boolean isTriggered(String line){
        return false;
    }

    public void setParams(RamCollection params){
    }

    public boolean doAction(Iterator<String> lines){
        Pattern p = Pattern.compile("\\s*;\\s*$");
        Matcher m = p.matcher(lines.next());
        if (!m.matches())
            return false;
        lines.next();
        return true;
    }

    public Validator clone(){
        return new EndLineValidator();
    }

}
