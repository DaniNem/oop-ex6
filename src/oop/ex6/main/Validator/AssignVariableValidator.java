package oop.ex6.main.Validator;
import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Created by shani on 15/06/2017.
 */
public class AssignVariableValidator implements Validator {
    private final String EQUALS_SIGN = "=";
    String line;

    public boolean isTriggered(String line){
        Pattern trigger = Pattern.compile(EQUALS_SIGN);
        Matcher m = trigger.matcher(line);
        if (m.find()){
            return true;
        }
        return false;
    }
    public void setParams(RamCollection params){
        String[] param = line.split(EQUALS_SIGN);
        if (params.hasVariable(param[0])){
        }

    }

    public boolean doAction(Iterator<String> lines){
        return true;
    }

    public Validator clone(){
        return new AssignVariableValidator();
    }
}
