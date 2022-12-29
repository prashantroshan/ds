package org.example;

public class LargestSumContiguousArrayWithSubarray {
    public static void kadanes(int[] val) {
        int maxEndingHere =0;
        int maxSoFar=Integer.MIN_VALUE;
        int start =0;
        int end =0;
        int s=0;

        for(int i = 0; i<val.length; i++) {
            maxEndingHere = maxEndingHere + val[i];

            if(maxEndingHere > maxSoFar) {
                maxSoFar= maxEndingHere;
                start=s;
                end=i;
            }

            if(maxEndingHere < 0) {
                maxEndingHere =0;
                s= i+1;
            }
        }

        System.out.println("Maximum contiguous sum is "
                + maxSoFar);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);

    }

    public static void main(String[] args) {
        kadanes(new int[]{1,-3,2,5,6,7});
    }
}
