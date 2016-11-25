package com.natasha.sourceit.task13;

import com.natasha.sourceit.task13.generic.DateCollection;
import com.natasha.sourceit.task13.generic.GenericCollection;
import com.natasha.sourceit.task13.generic.StringArrayList;
import com.natasha.sourceit.task13.generic.StringCollection;

import java.util.Date;
import java.util.Random;

public class Main {

    public static void main(String[] args) {






	    ObjectCollection oc = new ObjectCollection(4);
        testPrint(oc);
        oc.add(45);
        testPrint(oc);
        oc.add(87f);
        testPrint(oc);
        oc.add("hgdgdhg");
        testPrint(oc);
        oc.add(new Date());
        testPrint(oc);
        oc.add(new Random());
        testPrint(oc);
        oc.add(new Exception());
        testPrint(oc);


        Object o;
        while ((o = oc.removeLast()) != null) {
            System.out.println("Removed - " + o.getClass().getName());
            testPrint(oc);
        }

        DateCollection dc = new DateCollection(5);
        dc.add(new Date());
        dc.removeLast();

        StringCollection scoll1 = new StringCollection(10);
        scoll1.add("fdhgdsjfdf");


        GenericCollection<Integer> iColl = new GenericCollection<>(8);
        iColl.add(5);
        StringArrayList sal = new StringArrayList(5);
        sal.add("sfjhgfkf");
    }

    private static void testPrint(ObjectCollection collect) {
        System.out.println(String.format("Nelements = %d,   buffer=%d", collect.size(), collect.internalBufferSize()));
    }

}
