package oop.ex6.main.Validator;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shani on 16/06/2017.
 */
public abstract class DeclareVariableValidator implements Validator {
    protected boolean isFinal;

    protected String isFinal(String line){
        Pattern isFinal = Pattern.compile("\\s*final\\s+");
        Matcher m = isFinal.matcher(line);
        this.isFinal = m.lookingAt();
        m.replaceFirst("");
        return line;
    }

    protected String[] getVar(String line) {
        Pattern p = Pattern.compile("\\s");
        Matcher m = p.matcher(line);
        line = m.replaceAll("");
        String[] vars = line.split("\\s*,\\s*");
        return vars;
    }

}
