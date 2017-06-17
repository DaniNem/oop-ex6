package oop.ex6.main.RAMCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Admin on 15-Jun-17.
 */
public class RamCollection  {
    private ArrayList<Variable> variables;
    private ArrayList<Function> functions;
    private Stack<ArrayList<Variable>> scope;

    public RamCollection(){
        this.variables = new ArrayList<Variable>();
        this.functions = new ArrayList<Function>();
    }
    public void openScope(){
        //TODO this is a bad practice!!!!!
        this.scope.push((ArrayList<Variable> )this.variables.clone());
    }
    public void closeScope(){
        this.variables = this.scope.pop();
    }

    public void addFunction(String funName,Iterable<Variable> funVars){
        Function newFunc = new Function(funName);
        for (Variable var:funVars) {
            newFunc.addVar(var);
        }

        this.functions.add(newFunc);
    }
    public Function addFunction(String funName){
        Function newFunc = new Function(funName);
        this.functions.add(newFunc);
        return newFunc;
    }

    public Variable addVariable(String name, String type, String val, boolean isFinal) {
        Variable newVar = new Variable(name, type, isFinal);
        newVar.setValue(val);
        this.variables.add(newVar);
        return newVar;
    }

    public boolean hasVariable(String varName){
        for (Variable i:this.variables){
            if (i.getName() .equals(varName) ){
                return true;
            }
        }
        return false;
    }
    public Function getFunction(String funcName){
        if (this.hasFunction(funcName)){
            for (Function i:this.functions){
                if (i.getName() .equals(funcName) ){
                    return i;
                }
            }
        }
        throw new NoSuchElementException("No such function name");

    }
    public Variable getVariable(String varName){
        if (this.hasVariable(varName)){
            for (Variable i:this.variables){
                if (i.getName() .equals(varName) ){
                    return i;
                }
            }
        }
        throw new NoSuchElementException("No such variable name");

    }
    public boolean hasFunction(String funcName){
        for (Function i:this.functions){
            if (i.getName() .equals(funcName) ){
                return true;
            }
        }
        return false;
    }
    public Iterator<Function> getAllFunction(){
        return this.functions.iterator();
    }
/*    public RamCollection clone(){
        return new RamCollection(this);
    }*/
}

