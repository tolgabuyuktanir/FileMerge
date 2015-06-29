package edu.tou.withTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by tolga on 6/26/15.
 */
public class DataReading {
    TreeSet<Integer> treeSet=new TreeSet<Integer>();
    private List<String> inputs=new ArrayList<String>();
    public void readData()
    {
        for(int i=0;i<inputs.size();i++)
        {

            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader(inputs.get(i)));
                String str=null;
                while((str=bufferedReader.readLine())!=null)
                {
                    try
                    {
                        //System.out.println(Integer.parseInt(str));
                        treeSet.add(Integer.parseInt(str));

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
        try {
            writeSortedList(treeSet);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public void writeSortedList(TreeSet treeSet) throws IOException {
        //Dosya Yazma
        File file=new File("output.txt");
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        FileWriter fileWriter=new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        Iterator it=treeSet.iterator();
        while(it.hasNext())
        {
            try
            {
                bufferedWriter.write(it.next().toString()+"\n");
                System.out.println(it.next());
            }
            catch (Exception e)
            {
                System.err.println(e);
            }

        }
        bufferedWriter.close();

    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }
}
