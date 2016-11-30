package com.natasha.sourceit.hometask15;

import java.util.*;


public class CollectionArrayList {
    public static void sortArrayList() {
        ArrayList<String> s = new ArrayList<>();
        s.add("fdf");
        s.add("djskjfl;dsfkd");
        s.add("sdnmdfsdfskddsbvkcmnvcmvncmv");
        s.add("s");
        s.add("rfefdgrtgrgdfgfdggf");
        s.add("eg");

        System.out.println(s);


        List<String> s1 = new ArrayList<>(s);
        Collections.sort(s1);
        System.out.println("no arg sort - "+s1);

        List<String> s2 = new ArrayList<>(s);
        Collections.sort(s2, compNatural);
        System.out.println("o1.compTo(o2) - "+s2);

        List<String> s3 = new ArrayList<>(s);
        Collections.sort(s3, compNaturalInvert);
        System.out.println("o2.compTo(o1) - "+s3);

        List<String> s4 = new ArrayList<>(s);
        Collections.sort(s4, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("compare: "+o1+" - "+o2);
                return o1.length() - o2.length();
            }
        });
        System.out.println("sort length - "+s4);


        //-------------------  –учна€ сортировка чисел ----------------
        testSort(createIntArray(10));




    }


    private static void testSort(int[] inArray) {
        System.out.println("------ пример сортировки чисел --------------");
        System.out.println("before sort: "+Arrays.toString(inArray));

        for (int i=0; i<inArray.length-1; i++) {

            int minElement = inArray[i];
            int minElemIndex = i;
            for (int k = i; k<inArray.length; k++) {

                if (inArray[k] < minElement) {
                    minElement = inArray[k];
                    minElemIndex = k;
                }

            }
            int tmp = inArray[i];
            inArray[i] = inArray[minElemIndex];
            inArray[minElemIndex] = tmp;

        }

        System.out.println("after sort: "+Arrays.toString(inArray));
    }

    private static int[] createIntArray(int nElements) {
        Random rnd = new Random();
        int[] arr = new int[nElements];
        for (int i=0; i<nElements; i++) {
            arr[i] = rnd.nextInt(3000) + 50;
        }
        return arr;
    }


    private static Comparator<String> compNatural = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    private static Comparator<String> compNaturalInvert = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    };

}
