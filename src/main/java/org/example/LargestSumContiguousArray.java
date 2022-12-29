package org.example;

public class LargestSumContiguousArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int minValue = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length; i++) {
            sum = sum + nums[i];
            if(sum > minValue) {
                minValue = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        System.out.println(minValue);
        return minValue;
    }

    public static void main(String[] args) {
        new LargestSumContiguousArray().maxSubArray(new int[]{1,2,3,-2,5});
    }
}
