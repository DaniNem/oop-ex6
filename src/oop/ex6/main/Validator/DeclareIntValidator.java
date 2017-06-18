package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */

public class DeclareIntValidator extends DeclareVariableValidator{
    private String pattern = "int\\s+";
    private String typePattern = "(-?\\d)";

    protected String getPattern(){
        return pattern;
    }

    protected String getType(){
        return typePattern;
    }

    public Validator clone(){
        return new DeclareIntValidator();
    }
}
