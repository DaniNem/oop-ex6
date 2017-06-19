package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */
public class DeclareCharValidator extends DeclareVariableValidator {
    private String pattern = "[a-zA-Z\\s]*char[\\s\\t]*((_[a-zA-Z])|([a-zA-Z]))[a-zA-Z_]*.*";
    private String typePattern = "^'.'$";

    protected String getPattern(){
        return pattern;
    }
    protected String getPatternA(){
        return "^\\s*char\\s*";
    }

    protected String getType(){
        return typePattern;
    }

    public Validator clone(){
        return new DeclareCharValidator();
    }
}
