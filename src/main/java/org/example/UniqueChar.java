package org.example;

public class UniqueChar {

    public static int firstUniqChar(String s) {
        String[] str = s.split("");
        int res = -1;
        for(int i = 0 ;i < str.length; i++) {
            String val = str[i];
            int indx = s.substring(i+1,s.length()).indexOf(val);
            if(indx == -1){
                res= i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
