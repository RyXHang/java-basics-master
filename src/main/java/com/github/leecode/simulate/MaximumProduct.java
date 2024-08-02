package com.github.leecode.simulate;

import java.util.Arrays;

class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        long candidateAns1 = (long) nums[0] * nums[1] * nums[nums.length - 1];
        long candidateAns2 = (long) nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return (int) Math.max(candidateAns1, candidateAns2);
    }

    public static void main(String[] args) {
        MaximumProduct solution = new MaximumProduct();

        // 测试用例1: 包含正数和负数
        int[] testCase1 = {-10, -10, 5, 2};
        System.out.println(solution.maximumProduct(testCase1)); // 500

        // 测试用例2: 全为正数
        int[] testCase2 = {1, 2, 3, 4};
        System.out.println(solution.maximumProduct(testCase2)); // 24

        // 测试用例3: 全为负数
        int[] testCase3 = {-1, -2, -3, -4};
        System.out.println(solution.maximumProduct(testCase3)); // -6

        // 测试用例4: 混合正数和负数
        int[] testCase4 = {-4, -3, -2, -1, 60};
        System.out.println(solution.maximumProduct(testCase4)); // 720

        // 测试用例5: 包含零和负数
        int[] testCase5 = {-1, -2, 0, 1};
        System.out.println(solution.maximumProduct(testCase5)); // 2
    }
}
