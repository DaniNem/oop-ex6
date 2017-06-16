package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by shani on 15/06/2017.
 */
public class CloseBlockValidator implements Validator {

    public boolean isTriggered(String line){
        Pattern trigger = Pattern.compile("\\s*}");
        Matcher m = trigger.matcher(line);
        if (m.lookingAt())
            return true;
        return false;
    }

    public void setParams(RamCollection params){
    }


    public boolean doAction(Iterator<String> lines){
        Pattern linePattern = Pattern.compile("\\s*}\\s*");
        Matcher m = linePattern.matcher(lines.next());
        if (!m.matches())
            return false;
        if (lines.hasNext())
            lines.next();
        return true;
    }

    public Validator clone(){
        return new CloseBlockValidator();
    }
}
