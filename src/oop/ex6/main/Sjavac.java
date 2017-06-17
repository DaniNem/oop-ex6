package oop.ex6.main;


import oop.ex6.main.RAMCollection.Function;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.Validator.EngineValidartor;
import oop.ex6.main.Validator.FunctionEngineValidator;
import oop.ex6.main.Validator.Validator;

import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Sjavac {
    public Sjavac(){
        // here we going to read the code and put it in a iter.
        Iterator<String> lines;
        RamCollection myRam = new RamCollection();
        Validator engine = new EngineValidartor();
        engine.setParams(myRam);
        try{
            engine.doAction(lines);
        }catch (Exception e){
            //think it is best to move to exception here....

            System.err.println("1" + e.getMessage());
        }
        //done with global sope starting with function

        Iterator<Function> funcIter = myRam.getAllFunction();
        engine = new FunctionEngineValidator();
        while (funcIter.hasNext()){
            Function func = funcIter.next();
            engine.setParams(myRam);
            engine.doAction(func.getCode());
        }

    }

    public static void main(String[] args) {
    }
}

