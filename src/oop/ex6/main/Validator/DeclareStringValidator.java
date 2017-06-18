package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */
public class DeclareStringValidator extends DeclareVariableValidator{

    private String pattern = "String\\s+";
    private String typePattern = "^\".*\"$";

    protected String getPattern(){
        return pattern;
    }

    protected String getType(){
        return typePattern;
    }
    public Validator clone(){
        return new DeclareStringValidator();
    }
}
