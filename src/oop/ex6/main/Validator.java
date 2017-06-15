package oop.ex6.main;

import java.util.Collection;

/**
 * Created by Admin on 15-Jun-17.
 */
public interface Validator{
    public abstract boolean isTriggered(String line);
    public abstract void setParams(Collection<Ram> params);
    public abstract Collection<ValidatorResult> doAction(String line);
    public abstract Validator clone();
    
}
