package oop.ex6.main.Validator;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Created by shani on 15/06/2017.
 */
public class AssignVariableValidator implements Validator {
    private String curLine;
    private RamCollection ram;
    static final String INT = "-?\\d";
    static final String DOUBLE = "-?\\d+.\\d+|"+INT;
    static final String STRING = "^\".*\"$";
    static final String CHAR = "^'.'$";
    static final String BOOLEAN = "true|false|"+DOUBLE;

    private final String pattern = "\\s*[a-zA-Z_][a-zA-Z_\\d]*\\s*=\\s*[^\\s]+\\s*";
    private EndLineValidator endLine = new EndLineValidator();

    public boolean isTriggered(String line){
        if (line.contains(pattern)){
            curLine = line;
            return true;
        }
        return false;
    }
    public void setParams(RamCollection params){
        ram = params;
    }

    public boolean doAction(Iterator<String> lines){
        if (endLine.isTriggered(curLine)) {
            String[] param = curLine.split(pattern, 2);
            if (param.length == 2) {
                if (ram.hasVariable(param[0])) {
                    Variable var = ram.getVariable(param[0]);
                    if (!var.isFinal()) {
                        if (ram.hasVariable(param[1])) {
                            Variable assignedVal = ram.getVariable(param[1]);
                            if (var.getType().equals(assignedVal.getType())) {
                                var.setValue(assignedVal.getValue());
                                return true;
                            }
                        } else if (kindOf(param[1], var.getType())) {
                            var.setValue(param[1]);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public Validator clone(){
        return new AssignVariableValidator();
    }


    public static String getType(String var){
        if (var.matches(INT))
            return "int";
        if (var.matches(DOUBLE))
            return "double";
        if (var.matches(STRING))
            return "String";
        if (var.matches(CHAR))
            return "char";
        if (var.matches(BOOLEAN))
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

    public static boolean kindOf(String var, String type){
        switch (type){
            case ("int"):{
                return (var.matches(INT));
            }case ("double"):{
                return (var.matches(DOUBLE));
            }case ("String"):{
                return (var.matches(STRING));
            }case ("char"):{
                return (var.matches(CHAR));
            }case ("boolean"):{
                return (var.matches(BOOLEAN));
            }
        }return false;
    }
}
