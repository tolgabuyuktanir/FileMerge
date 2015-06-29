package edu.tou.withTree;

import java.util.ArrayList;

/**
 * Created by tolga on 6/29/15.
 */
public class FileMerge {
    public static void main(String[] args) {
        DataReading dataReading=new DataReading();
        ArrayList<String> inputs=new ArrayList<String>();
        inputs.add("1.txt");
        inputs.add("2.txt");
        inputs.add("3.txt");
        inputs.add("4.txt");
        inputs.add("5.txt");
        dataReading.setInputs(inputs);
        dataReading.readData();
    }
}
