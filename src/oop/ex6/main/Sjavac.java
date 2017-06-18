package oop.ex6.main;


import oop.ex6.main.RAMCollection.Function;
import oop.ex6.main.RAMCollection.RamCollection;
import oop.ex6.main.Validator.EngineValidator;
import oop.ex6.main.Validator.FunctionEngineValidator;
import oop.ex6.main.Validator.Validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Sjavac {
    public Sjavac(String path) throws IOException {
        // here we going to read the code and put it in a iter.
        ArrayList<String> sb = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {

            String line = br.readLine();

            while (line != null) {
                sb.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


        Iterator<String> lines = sb.iterator();
        RamCollection myRam = new RamCollection();
        Validator engine = new EngineValidator();
        engine.setParams(myRam);
        try{
            System.out.println(engine.doAction(lines));
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

    public static void main(String[] args) throws IOException {
        Sjavac run = new Sjavac(args[0]);
    }
}

