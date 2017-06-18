package oop.ex6.main.Validator;

/**
 * Created by shani on 18/06/2017.
 */
public class DeclareDoubleValidator extends DeclareVariableValidator {

    private String pattern = "double\\s+";
    private String typePattern = "(-?\\d+.\\d+)|(-?\\d)";

    protected String getPattern(){
        return pattern;
    }

    protected String getType(){
        return typePattern;
    }

    public Validator clone(){
        return new DeclareDoubleValidator();
    }
}

