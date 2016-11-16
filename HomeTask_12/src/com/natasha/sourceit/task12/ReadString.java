package com.natasha.sourceit.task12;

import java.io.*;

/**
 * Created by Stas on 13.11.2016.
 */
public class ReadString {
    public static void readString() throws IOException {
        File myFile = new File("C:\\git-projects\\HomeTask\\HomeTask_12\\MyText.txt");
        BufferedReader reader = new BufferedReader(new FileReader((myFile)));
        String line;
        while ((line = reader.readLine()) != null) {
            System.err.println("new line - " + line);
        }
        reader.close();
    }

    public static void readString1() throws IOException{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\git-projects\\HomeTask\\HomeTask_12\\MyText1.txt"));
        dos.writeUTF("AA");
        dos.writeUTF("BBB");
        dos.writeUTF("BBB\n");
        dos.writeUTF("ЫЫ");
        dos.writeUTF("CC");
        dos.close();
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\git-projects\\HomeTask\\HomeTask_12\\MyText1.txt"));
        String line;
        int aval;
        while(((aval = dataInputStream.available()) > 0) && (line = dataInputStream.readUTF()) != null) {
            System.err.println("available="+aval+";  new UTF string - "+line);
        }
        dataInputStream.close();
    }

    public static void readStringChar() throws IOException{
        InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\git-projects\\HomeTask\\HomeTask_12\\MyText1.txt"));
        int data;
        while((data = inputStream.read()) != -1) {
            System.err.print((char) data);
        }
        System.err.println();
        inputStream.close();
    }
}
