package oop.ex6.main.Validator;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shani on 16/06/2017.
 */
public abstract class DeclareVariableValidator implements Validator {
    private final String FINAL = "final";
    protected boolean isFinal;

    protected String isFinal(String line){
        Pattern isFinal = Pattern.compile("\\s*FINAL\\s+");
        Matcher m = isFinal.matcher(line);
        this.isFinal = m.lookingAt();
        m.replaceFirst("");
        return line;
    }
}
