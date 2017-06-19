package oop.ex6.main.RAMCollection;

import java.util.*;

/**
 * Created by Admin on 15-Jun-17.
 */
public class RamCollection  {
    private ArrayList<Variable> variables;
    private ArrayList<ArrayList <Variable>> globalVariables;
    private ArrayList<Function> functions;

    public RamCollection(){
        this.variables = new ArrayList<Variable>();
        this.globalVariables = new  ArrayList<ArrayList <Variable>> ();
        this.functions = new ArrayList<Function>();
    }
    public void openScope(){
        ArrayList<Variable> cloned = new ArrayList<Variable>();
        for (Variable v: this.variables){
            cloned.add(v.clone());
        }
        //this.scope.push(cloned);
        this.globalVariables.add(cloned);
        this.variables = new ArrayList<Variable>();
    }
    //TODO change the exception to specific one
    public void closeScope() throws Exception
    {
        if (!this.globalVariables.isEmpty()){
              this.variables = this.globalVariables.get(this.globalVariables.size()-1);
              this.globalVariables.remove(this.globalVariables.size()-1);
            }
            else {
                throw new Exception("pipi kaki");
            }
            //this.variables = this.scope.pop();
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

    public Variable addVariable(String name, String type, boolean isFinal) {
        Variable newVar = new Variable(name, type, isFinal);
        this.variables.add(newVar);
        return newVar;
    }
    public void addVariable(Variable var) {
        this.variables.add(var);
    }

    public boolean hasVariable(String varName){
        for (Variable i:this.variables){
            if (i.getName() .equals(varName) ){
                return true;
            }
        }
        return false;
    }

    public boolean hasVariableGlobal(String varName){
        for (int i = this.globalVariables.size()-1;i>=0;i--){
            ArrayList<Variable> curScope = this.globalVariables.get(i);
            for (Variable v:curScope){
                if (v.getName() .equals(varName) ){
                    return true;
                }
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
    public Iterator<Variable> getAllVariables(){
        return this.variables.iterator();

    }
    public Variable getVariableGlobal(String varName){
        for (int i = this.globalVariables.size()-1;i>=0;i--){
            ArrayList<Variable> curScope = this.globalVariables.get(i);
            for (Variable v:curScope){
                if (v.getName() .equals(varName) ){
                    return v;
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

