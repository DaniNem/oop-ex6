package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.Ram;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public interface Validator{
    public abstract boolean isTriggered(String line);
    public abstract void setParams(Collection<Ram> params);
    public abstract Collection<ValidatorResult> doAction(Iterator<String> lines);
    public abstract Validator clone();
    
}
