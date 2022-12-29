package org.example;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<String, Integer> map1 = getCharCount(s);
        Map<String, Integer> map2 = getCharCount(t);

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) == null || map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> getCharCount(String str) {
        String[] st = str.split("");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : st) {
            if (map1.containsKey(s)) {
                int val = map1.get(s);
                map1.put(s, val + 1);
            } else {
                map1.put(s, 1);
            }
        }
        return map1;
    }
}
