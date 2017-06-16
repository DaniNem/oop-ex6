package oop.ex6.main.Validator;
import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Created by shani on 15/06/2017.
 */
public class AssignVariable implements Validator {
    static final Pattern INT = Pattern.compile("\\d");
    static final Pattern DOUBLE = Pattern.compile("\\d+.\\d+");
    static final Pattern STRING = Pattern.compile("^'.*'$");
    static final Pattern CHAR = Pattern.compile(".");
    static final Pattern BOOLEAN = Pattern.compile("true|false");

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
        return new AssignVariable();
    }


    public static String getType(String var){
        Matcher m = INT.matcher(var);
        if (m.matches())
            return "int";
        m = DOUBLE.matcher(var);
        if (m.matches())
            return "double";
        m = STRING.matcher(var);
        if (m.matches())
            return "string";
        m = CHAR.matcher(var);
        if (m.matches())
            return "char";
        m = BOOLEAN.matcher(var);
        if (m.matches())
            return "boolean";
        return null;
    }

    public static boolean isType(String type1, String type2){
        if (type1 == "int"){
            if (type2.equals("double") || type2.equals("boolean"))
                return true;
        }else if (type1 == "double")
            if (type2.equals("boolean"))
                return true;

        return false;
    }
}
