package com.natasha.sourceit.task12;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        ReadString.readString();
        System.err.println("------------------------------");
        ReadString.readString1();
        System.err.println("------------------------------");
        ReadString.readStringChar();
        System.err.println("------------------------------");
        ReadByte.readByte();
        Record.recordToFile("C:\\git-projects\\HomeTask\\HomeTask_12\\MyRecord.txt");

        Record.recordIntToFile(2000, "C:\\git-projects\\HomeTask\\HomeTask_12\\MyRecord1.txt");

    }
}
