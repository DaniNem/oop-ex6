package oop.ex6.main.RAMCollection;

import java.util.ArrayList;

/**
 * Created by Admin on 15-Jun-17.
 */
public class RamCollection  {
    private ArrayList<Variable> variables;
    private ArrayList<Function> functions;

    public RamCollection(){
        this.variables = new ArrayList<Variable>();
        this.functions = new ArrayList<Function>();
    }

    public boolean hasVariable(String varName){
        for (Variable i:this.variables){
            if (i.getName() == varName){
                return true;
            }
        }
        return false;
    }
    public boolean hasFunction(String funcName){
        for (Function i:this.functions){
            if (i.getName() == funcName){
                return true;
            }
        }
        return false;
    }
/*    public RamCollection clone(){
        return new RamCollection(this);
    }*/
}

