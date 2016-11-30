package com.natasha.sourceit.hometask15;

import javax.print.attribute.IntegerSyntax;
import java.util.*;


public class CollectionMap {

    public static void sortMap() {
        System.out.println("----------------  sortMap()  ------------------");
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "df5");
        m.put(2,"gdhfhgygefsdf");
        m.put(3, "efdgdddddddkkkjedisakdsa");
        m.put(4, "fs");
        m.put(5, "n");

        System.out.println("initial map - "+m);

        System.out.println("-----sort lenght--------");
        List<Map.Entry<Integer, String>> s = new ArrayList<>(m.entrySet());
        System.out.println("initial list - "+s);
        Collections.sort(s, comLenght);
        System.out.println("sorted list lenght - " + s);
        m = new LinkedHashMap<>();
        for(Map.Entry<Integer, String> ent : s){
            m.put(ent.getKey(), ent.getValue());
        }
        System.out.println("result map - " + m);

        System.out.println("-----sort alphabet in increasing order --------");
        List<Map.Entry<Integer, String>> s1 = new ArrayList<>(m.entrySet());
        System.out.println("initial list - "+s1);
        Collections.sort(s1, comGrow);
        System.out.println("sorted list lenght - " + s1);
        m = new LinkedHashMap<>();
        for(Map.Entry<Integer, String> ent : s1){
            m.put(ent.getKey(), ent.getValue());
        }
        System.out.println("result map - " + m);

        System.out.println("-----sort alphabet in decreasing order --------");
        List<Map.Entry<Integer, String>> s2 = new ArrayList<>(m.entrySet());
        System.out.println("initial list - "+s2);
        Collections.sort(s2, comDecr);
        System.out.println("sorted list lenght - " + s2);
        m = new LinkedHashMap<>();
        for(Map.Entry<Integer, String> ent : s2){
            m.put(ent.getKey(), ent.getValue());
        }
        System.out.println("result map - " + m);
    }

    private static Comparator<Map.Entry<Integer, String>> comLenght = new Comparator<Map.Entry<Integer, String>>() {
        @Override
        public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
            return o1.getValue().length() - o2.getValue().length();
        }
    };

    private static Comparator<Map.Entry<Integer, String>> comGrow = new Comparator<Map.Entry<Integer, String>>() {
        @Override
        public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    };

    private static Comparator<Map.Entry<Integer, String>> comDecr = new Comparator<Map.Entry<Integer, String>>() {
        @Override
        public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    };
}
