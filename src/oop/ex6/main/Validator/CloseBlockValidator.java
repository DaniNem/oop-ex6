package oop.ex6.main.Validator;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by shani on 15/06/2017.
 */
public class CloseBlockValidator implements Validator {

    private String CLOSE_BLOCK = "}";

    public boolean isTriggered(String line){
        Pattern trigger = Pattern.compile("\\s*CLOSE_BLOCK");
        Matcher m = trigger.matcher(line);
        if (m.lookingAt())
            return true;
        return false;
    }

    public void setParams(RamCollection params){
    }


    public boolean doAction(Iterator<String> lines){
        Pattern linePattern = Pattern.compile("\\s*CLOSE_BLOCK\\s*");
        Matcher m = linePattern.matcher(lines.next());
        if (!m.matches())
            return false;
        lines.next();
        return true;
    }

    public Validator clone(){
        return new CloseBlockValidator();
    }
}
