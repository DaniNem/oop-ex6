package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;

/**
 * Created by Admin on 20-Jun-17.
 */
public class TabsAndSpaceValidator implements Validator {
    private String pattern = "[\\s\\t]+?";
    private boolean isTriggered;
    private RamCollection localRam;

    public boolean isTriggered(String line) {
        return  (line.matches(pattern));
    }

    public void setParams(RamCollection params) {
        localRam = params;
    }


    public boolean doAction(Iterator<String> lines) {
        return true;
    }
}