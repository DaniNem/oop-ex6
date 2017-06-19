package oop.ex6.main.TextToIter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 18-Jun-17.
 */
public class TextToIter {
    public Iterator<String> convert(String path) throws IOException {
        ArrayList<String> sb = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {

            String line = br.readLine();

            while (line != null) {
                if (!line.equals("")) sb.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return sb.iterator();
    }


}
