package oop.ex6.main.RAMCollection;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Variable {
    private String name,type,value,scope;
    private boolean isFinal;

    public Variable(String name,String type,boolean isFinal){
        this.name = name;
        this.type = type;
        this.isFinal = isFinal;
    }

    public String getName() {
        return name;
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
