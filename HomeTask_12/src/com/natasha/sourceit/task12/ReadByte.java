package com.natasha.sourceit.task12;

import java.io.*;

/**
 * Created by Stas on 13.11.2016.
 */
public class ReadByte {
    public static void readByte() throws IOException{

        InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\git-projects\\HomeTask\\HomeTask_12\\MyText.txt"));
        int data;
        do {
            data = inputStream.read();
            System.err.print((byte)data + " ");
        } while(data >= 0) ;
        inputStream.close();
    }
}
