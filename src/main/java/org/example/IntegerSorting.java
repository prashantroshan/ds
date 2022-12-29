package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class IntegerSorting {

    /**
     * Integers sorted based on their frequency , in which insertion order is maintained
     * @param args
     */

    public static void main(String[] args) {
        Scanner scan 						= new Scanner(System.in);
        String str 							= scan.nextLine();
        String[] vals   					= str.split(" ");
        Map<String,Integer> sm 				= new LinkedHashMap<>();
        SortedMap<Integer,List<String>> ll 	= new TreeMap<>();

        for (String s : vals) {
            if(sm.containsKey(s)) {
                int v = sm.get(s);
                v++;
                sm.put(s, v);
            }else {
                sm.put(s, 1);
            }
        }

        for(Map.Entry<String,Integer> entry : sm.entrySet()) {
            if(ll.containsKey(entry.getValue())) {
                ll.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> tmp =new ArrayList<>();
                tmp.add(entry.getKey());
                ll.put(entry.getValue(),tmp);
            }
        }

        // ascending order//
        for (Map.Entry<Integer,List<String>> entry :ll.entrySet()) {
            List<String> val = entry.getValue();
            for(String s : val) {
                for(int i = 0; i< entry.getKey(); i++) {
                    System.out.print(s+" ");
                }
            }
        }
        System.out.println();
        // Descending order
        List<Integer> keys = new ArrayList<>(ll.keySet());
        Collections.reverse(keys);
        for (Integer m : keys) {
            List<String> val = ll.get(m);
            Collections.reverse(val);
            for(String s : val) {
                for(int i = 0; i< m; i++) {
                    System.out.print(s+" ");
                }
            }
        }
    }
}
