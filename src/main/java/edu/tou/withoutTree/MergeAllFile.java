package edu.tou.withoutTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tolga on 6/27/15.
 */
public class MergeAllFile {
    DataReading dataReading=new DataReading();
    ArrayList<String> inputs=new ArrayList<String>();

    //Dosya birleştirme işlemi bu metodda yapılmaktadır.
    public void mergeAllFile() throws IOException {
        //Dosya Okuma
        inputs.add("1.txt");
        inputs.add("2.txt");
        inputs.add("3.txt");
        inputs.add("4.txt");
        inputs.add("5.txt");
        dataReading.setInputs(inputs);
        dataReading.readData();
        ArrayList<Integer> indexToFindTheMinimum=new ArrayList<Integer>();
        ArrayList<Integer> minValuesOfInputLists=new ArrayList<Integer>();

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
        for(int i=0;i<dataReading.getInputList().size();i++)
        {
            indexToFindTheMinimum.add(0);
            minValuesOfInputLists.add(0);
        }
        int inputSize=0;
        for(int i=0;i<dataReading.getInputList().size();i++)
        {
            inputSize+=dataReading.getInputList().get(i).size();
        }
        for(int k=0;k<inputSize;k++)
        {
            //Hangi sıradaki eleman listeye eklenecek ?
            for(int i=0;i<indexToFindTheMinimum.size();i++)
            {
                if(indexToFindTheMinimum.get(i)==null)
                {
                    minValuesOfInputLists.set(i,null);
                }
                else
                {
                    minValuesOfInputLists.set(i, dataReading.getInputList().get(i).get(indexToFindTheMinimum.get(i)));

                }

            }
            //Min hangi dizinin elemanı
            if(indexToFindTheMinimum.get(minValuesOfInputLists.indexOf(findMin(minValuesOfInputLists)))<dataReading.getInputList().get(minValuesOfInputLists.indexOf(findMin(minValuesOfInputLists))).size()-1)
            {
                indexToFindTheMinimum.set(minValuesOfInputLists.indexOf(findMin(minValuesOfInputLists)),indexToFindTheMinimum.get(minValuesOfInputLists.indexOf(findMin(minValuesOfInputLists)))+1);
            }
            else
            {
                indexToFindTheMinimum.set(minValuesOfInputLists.indexOf(findMin(minValuesOfInputLists)), null);
            }
            System.out.println(findMin(minValuesOfInputLists));
            bufferedWriter.write(findMin(minValuesOfInputLists).toString()+"\n");
            }
        bufferedWriter.close();
        }
    public Integer findMin(ArrayList<Integer> list)
    {
        int min=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)!=null)
            {
                min=list.get(i);
                break;
            }
        }
        for(int i=0;i<list.size();i++)
        {
            while(list.get(i)==null)
            {
                i++;
            }
            if(min>list.get(i))
            {
                min=list.get(i);
            }
        }
        return min;
    }
}
