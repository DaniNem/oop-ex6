package oop.ex6.main.RAMCollection;

/**
 * Created by Admin on 15-Jun-17.
 */
public class Ram {
    private String type,name,argType,value,modifier,scope;
    public Ram(){
        scope = "local";
        type = null;
        name = null;
        argType = null;
        value = null;
        modifier = null;
    }
    public void setScopeToGlobal(){
        scope = "global";
    }
    public void setScopeToLocal(){
        scope = "local";
    }

    public String getScope() {
        return scope;
    }

    public String getArgType() {
        return argType;
    }

    public String getModifier() {
        return modifier;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setArgType(String argType) {
        this.argType = argType;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
