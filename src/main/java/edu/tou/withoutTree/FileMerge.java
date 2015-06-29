package edu.tou.withoutTree;

import java.io.IOException;

/**
 * Created by tolga on 6/25/15.
 */
public class FileMerge {

    /*Listeler sıralı bir şekilde tutulmaktadır.Dolayısıyla listelerin ilk elemanları en küçük eleman olacaktır.
    * Kaç liste var ise, her listenin ilk elemanı karşılaştırılmakta ve min olan dosyaya yazılmaktadır.Dosyaya hngi listeden eleman yazıldıysa o listenin
    * indexi bir arttırılmakta ve artık tüm listelern ikinci minimumu aranırken diğer elemanlara bakılablmektedir.*/

    public static void main(String[] args) {
        MergeAllFile mergeAllFile=new MergeAllFile();

        try {
            mergeAllFile.mergeAllFile();
        } catch (IOException e) {
            System.err.println(e);
        }

    }


}
