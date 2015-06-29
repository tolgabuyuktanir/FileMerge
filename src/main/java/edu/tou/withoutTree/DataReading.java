package edu.tou.withoutTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tolga on 6/26/15.
 */
public class DataReading {
    ArrayList<ArrayList<Integer>> inputList=new ArrayList<ArrayList<Integer>>();
    private List<String> inputs=new ArrayList<String>();
    public void readData()
    {
        for(int i=0;i<inputs.size();i++)
        {

            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader(inputs.get(i)));
                String str=null;
                inputList.add(new ArrayList<Integer>());
                while((str=bufferedReader.readLine())!=null)
                {
                    try
                    {
                        //System.out.println(Integer.parseInt(str));
                        inputList.get(i).add(Integer.parseInt(str));

                    }
                    catch (NumberFormatException e)
                    {
                        System.err.println(e);
                    }
                }
            } catch (java.io.IOException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getInputList() {
        return inputList;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }
}
