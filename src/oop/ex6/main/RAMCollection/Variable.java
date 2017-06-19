package oop.ex6.main.RAMCollection;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Variable {
    private String name,type;
    private boolean isFinal,hasValue;

    public Variable(){
    }

    public Variable(String name,String type,boolean isFinal){
        this.name = name;
        this.type = type;
        this.isFinal = isFinal;
        this.hasValue = false;
    }

    public String getName() {
        return name;
    }
    public Variable clone() {
        Variable retVal = new Variable();
        retVal.name = this.name;
        retVal.type = this.type;
        retVal.isFinal = this.isFinal;
        retVal.hasValue = this.hasValue;
        return retVal;
    }

    public boolean isHasValue(){
        return this.hasValue;
    }
    public void setHasValue(boolean val){
        this.hasValue = val;
    }

    public String getType(){
        return type;
    }

    public boolean isFinal(){
        return isFinal;
    }

    public void setFinal(boolean isFinal){
        this.isFinal = isFinal;
    }
}
