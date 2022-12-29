package org.example;

public class MaxSubArrayBruteForce {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2}));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < l; j++) {
                if (max < sum) {
                    max = sum;
                }
                sum = sum + nums[j];
            }
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}