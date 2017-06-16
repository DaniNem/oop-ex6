package oop.ex6.main.RAMCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Function {
    private ArrayList<Variable> vars;
    private String name;
    private String code;
    public Function(String name){
        this.name = name;
        this.vars = new ArrayList<Variable>();
    }
    public void addVar(Variable newVar){
        this.vars.add(newVar);
    }
    public Collection<Variable> getVars(){
        return this.vars;
    }
    public String getName(){
        return this.name;

    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
}
