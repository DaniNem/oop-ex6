package oop.ex6.main;


import oop.ex6.main.RAMCollection.Function;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.RAMCollection.Variable;
import oop.ex6.main.TextToIter.TextToIter;
import oop.ex6.main.Validator.EngineValidator;
import oop.ex6.main.Validator.FunctionEngineValidator;
import oop.ex6.main.Validator.Validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Sjavac {
    public Sjavac(String path)  {
        // here we going to read the code and put it in a iter.


        try{

        Iterator<String> lines = new TextToIter().convert(path);
        RamCollection myRam = new RamCollection();
        Validator engine = new EngineValidator();
        engine.setParams(myRam);
        engine.doAction(lines);

        //done with global sope starting with function

        Iterator<Function> funcIter = myRam.getAllFunction();
        engine = new FunctionEngineValidator();
        while (funcIter.hasNext()){
            Function func = funcIter.next();
            myRam.openScope();

            Iterator<Variable> vI = func.getVars().iterator();
            while (vI.hasNext()){
                myRam.addVariable(vI.next());
            }
            engine.setParams(myRam);
            engine.doAction(func.getCode());
        }
            System.out.println(0);
        }catch (IOException e){
            System.out.println("2");
        }catch (Exception e) {
            //think it is best to move to exception here....

            System.out.println("1");// + e.getMessage());
        }


    }

    public static void main(String[] args) throws IOException {
        Sjavac run = new Sjavac(args[0]);
    }
}

