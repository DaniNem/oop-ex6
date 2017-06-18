package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */
public class DeclareBooleanValidator extends DeclareVariableValidator {
    private String pattern = "boolean\\s+";
    private String typePattern = "(true)|(false)|(-?\\d+.\\d+)|(-?\\d)";

    protected String getPattern(){
        return pattern;
    }

    protected String getType(){
        return typePattern;
    }

    public Validator clone(){
        return new DeclareBooleanValidator();
    }
}
