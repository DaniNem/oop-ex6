package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 16-Jun-17.
 */
public class OpenBlockValidator implements Validator {
    RamCollection localRam;

    public boolean isTriggered(String line){
        //Pattern trigger = Pattern.compile("^(\\{)|([.//s]*+\\{)");
        //Pattern trigger = Pattern.compile(".*+\\{$");
        String trigger = ".*(\\{+\\s*)$";
        //Matcher m = trigger.matcher(line);
        if (line.matches(trigger))
            return true;
        return false;
    }

    public void setParams(RamCollection params) {
        this.localRam = params;
    }


    public boolean doAction(Iterator<String> lines){
        //Pattern linePattern = Pattern.compile("\\s*}\\s*");
        //Matcher m = linePattern.matcher(lines.next());
        //if (!m.matches())
        //    return false;
       // if (lines.hasNext())
       //     lines.next();
        //this.localRam.openScope();
        return true;
    }

    public Validator clone(){
        return new CloseBlockValidator();
    }
}
