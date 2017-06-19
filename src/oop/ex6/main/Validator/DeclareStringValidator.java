package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */
public class DeclareStringValidator extends DeclareVariableValidator{

    private String pattern = "[a-zA-Z\\s\\t]*String[\\s\\t]*((_[a-zA-Z])|([a-zA-Z]))[a-zA-Z_]*.*";
    private String typePattern = "^\".*\"$";

    protected String getPattern(){
        return pattern;
    }
    protected String getPatternA(){
        return "^\\s*String\\s*";
    }

    protected String getType(){
        return typePattern;
    }
    public Validator clone(){
        return new DeclareStringValidator();
    }
}
