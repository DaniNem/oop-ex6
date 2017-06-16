package oop.ex6.main.Validator;

import com.sun.deploy.security.ValidationState;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by shani on 15/06/2017.
 */
public class DeclareIntValidator extends DeclareVariableValidator{
    private String line;
    private Variable variable;
    private Pattern trigger;
    private Matcher matcher;
    boolean hasError = false;


    DeclareIntValidator(){
        trigger = Pattern.compile("\\s*int\\s+");
        Matcher matcher = trigger.matcher(line);
    }


    public boolean isTriggered(String line){
        if (matcher.find()) {
            this.line = line;
            return true;
        }
        return false;

    }
    public void setParams(RamCollection params){
        if (!isDeclare())
            hasError = true;



        String[] vars = line.split("\\s*,\\s*");
        for (String i: vars){

        }

    }

    public boolean doAction(Iterator<String> lines){
        if (hasError)
            return false;
        lines.next();
        return true;
    }

    public Validator clone(){
        return new DeclareIntValidator();
    }

    private boolean isDeclare(){
        this.line = isFinal(line);
        if (matcher.lookingAt()) {
            this.line = matcher.replaceFirst("");
            return true;
        }
        return false;
    }

}
