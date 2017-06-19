package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public interface Validator{
    public abstract boolean isTriggered(String line);
    public abstract void setParams(RamCollection params);
    public abstract boolean doAction(Iterator<String> lines) throws Exception;
    //public abstract Validator clone();
    
}
