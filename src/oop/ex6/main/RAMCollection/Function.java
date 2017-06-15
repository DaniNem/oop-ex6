package oop.ex6.main.RAMCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Function {
    private ArrayList<Variable> vars;
    private String name;
    public Function(){
        this.vars = new ArrayList<Variable>();
    }
    public void addVar(Variable newVar){
        this.vars.add(newVar);
    }
    public Iterator<Variable> getVars(){
        return this.vars.iterator();
    }
    public String getName(){
        return this.name;

    }
    public void setName(String name) {
        this.name = name;
    }
}
