package oop.ex6.main.Validator;

import oop.ex6.main.RAMCollection.RamCollection;

import java.util.Iterator;

/**
 * Created by Admin on 16-Jun-17.
 */
public class IfWhileValidator implements Validator{
    String curLine;
    RamCollection localRam;
    @Override
    public boolean isTriggered(String line) {
        curLine = line;
        String pattern  = "^(if|while)+\\s*+\\(+[\\w\\s]+\\)+\\s*+\\{$";
        return line.matches(pattern);
    }

    @Override
    public void setParams(RamCollection params) {
        this.localRam = params;
    }

    @Override
    public boolean doAction(Iterator<String> lines) {
        String condition = this.curLine.replaceAll("^(if|while)+\\s*+\\(", "").replaceAll("\\)+.*+\\{","");
        String calledVars =curLine.replaceAll("^[a-zA-Z\\s]*+[(]", "")
                .replaceAll("[)]+[{]$", "");
        String[] vars = curLine.split(",");
        //blockofcode working on making string to vars;
        throw new Exception("Finish on this...");
        String code = "";
        int openSocpeCounter = 0;
        Validator close = new CloseBlockValidator();
        Validator open = new OpenBlockValidator();
        while(lines.hasNext()){
            String nextLine = lines.next();

            if(open.isTriggered(nextLine)){
                openSocpeCounter++;
            }
            else if (close.isTriggered(nextLine)){
                openSocpeCounter--;
                if (openSocpeCounter < -1){
                    code += nextLine;
                    break;
                }
            }
            code += nextLine + '\n';
        }
        if(code.length()==0)throw new Exception("End of file.. no closing...");
    }

    @Override
    public Validator clone() {
        return null;
    }
}
