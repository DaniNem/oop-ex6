package oop.ex6.main.RAMCollection;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Variable {
    private String name,type,value,modifier,scope;
    public Variable(String name,String type,String modifier){
        this.scope = "local";
        this.name = name;
        this.type = type;
        this.value = value;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }
}
