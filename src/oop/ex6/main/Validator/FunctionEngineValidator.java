package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class FunctionEngineValidator implements Validator {
    private ArrayList<Validator> simpleValidators;
    private RamCollection ram;
    private Validator closed;
    private Validator ret;
    private Validator open;
    //private Validator comment;
    //private Validator endRow;

    public FunctionEngineValidator clone(){
        return null;
    }
    public FunctionEngineValidator() {
        this.simpleValidators = new ArrayList< Validator>();
        this.simpleValidators.add(new AssignVariableValidator());
        this.simpleValidators.add(new VariableDeclareEngine());
        this.simpleValidators.add(new CallMethodValidator());
        this.simpleValidators.add(new IfWhileValidator());
        this.simpleValidators.add(new CommentValidator());
        this.simpleValidators.add(new TabsAndSpaceValidator());
        this.closed = new CloseBlockValidator();
        this.open = new OpenBlockValidator();
        this.ret = new ReturnValidator();


    }

    @Override
    public boolean isTriggered(String line) {
        return true;
    }

    @Override
    public void setParams(RamCollection params) {
        this.ram = params;

    }

    @Override
    public boolean doAction(Iterator<String> lines) throws Exception{
        boolean triggered;
        boolean retFlag = false;
        int scopeNumber = 0;
        while (lines.hasNext()) {
            triggered = false;
            String line = lines.next();
            for (Validator v : this.simpleValidators) {
                v.setParams(this.ram);
                if (v.isTriggered(line)) {
                    triggered = true;
                    v.doAction(lines);
                    break;
                }
            }
            if (open.isTriggered(line)){
                triggered = true;
                scopeNumber++;
            }
            if (closed.isTriggered(line)){
                triggered = true;
                if(!retFlag && scopeNumber==1){
                    throw new Exception("Must Have return!!");
                }
                closed.setParams(this.ram);
                closed.doAction(lines);
                scopeNumber--;
            }
            if (ret.isTriggered(line)){
                retFlag = true;
                ret.setParams(this.ram);
                ret.doAction(lines);
                triggered = true;
            }
            else retFlag = false;

            if (!triggered) throw new Exception("Engine Function validator");
        }
        return true;
    }
}