package org.example;

public class LargestmultiplyContiguousArray {
    public int maxSubArray(int[] nums) {
        int sum = 1;
        int minValue = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length; i++) {
            sum = sum * nums[i];
            if(sum > minValue) {
                minValue = sum;
            }
            if(sum < 1) {
                sum = 1;
            }
        }
        System.out.println(minValue);
        return minValue;
    }

    public static void main(String[] args) {
        new LargestmultiplyContiguousArray().maxSubArray(new int[]{1,2,3,-2,5});
    }
}
