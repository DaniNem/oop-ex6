package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 15-Jun-17.
 */
public class EngineValidator implements Validator{
    private ArrayList< Validator> simpleValidators;
    private RamCollection ram;

    public EngineValidator(){
        this.simpleValidators = new ArrayList<Validator>();
        this.simpleValidators.add(new AssignVariableValidator());
        this.simpleValidators.add(new VariableDeclareEngine() );
        this.simpleValidators.add(new DefinedMethodValidator());
        this.simpleValidators.add(new CommentValidator());
        this.simpleValidators.add(new TabsAndSpaceValidator());
    }
    @Override
    public boolean isTriggered(String line)
    {

        return true;
    }

    @Override
    public void setParams(RamCollection params) {
        this.ram = params;

    }

    @Override
    public boolean doAction(Iterator<String> lines) throws Exception{
        boolean triggered;
        while (lines.hasNext()){
            triggered = false;
            String line = lines.next();
            for (Validator v:this.simpleValidators){
                v.setParams(this.ram);
                if (v.isTriggered(line)){
                    triggered = true;
                    v.doAction(lines);
                    break;
                }
            }
            if (!triggered)throw new Exception("No trigger in engine");
        }
        return true;
    }

    @Override
    public Validator clone() {
        return null;
    }
}
