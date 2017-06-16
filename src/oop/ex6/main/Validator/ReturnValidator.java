package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class ReturnValidator implements Validator {
    String curLine;
    @Override
    public boolean isTriggered(String line) {
        this.curLine = curLine;
        String pattern = "^return;";
        return line.matches(pattern);
    }

    @Override
    public void setParams(RamCollection params) {
        return;
    }

    @Override
    public boolean doAction(Iterator<String> lines) {
        return this.isTriggered(this.curLine);
    }

    @Override
    public Validator clone() {
        return new ReturnValidator();
    }
}
