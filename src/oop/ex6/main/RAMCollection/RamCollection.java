package oop.ex6.main.RAMCollection;

import java.util.ArrayList;

/**
 * Created by Admin on 15-Jun-17.
 */
public class RamCollection extends ArrayList<Ram> {
    public RamCollection(RamCollection db){
        for (Ram i:db) {
            this.add(i);
        }
    }
    public RamCollection(){
        super();
    }
    public void turnScopeToGlobal(){
        for (Ram i:this) {
            i.setScopeToGlobal();
        }
    }
    public RamCollection clone(){
        return new RamCollection(this);
    }
}

