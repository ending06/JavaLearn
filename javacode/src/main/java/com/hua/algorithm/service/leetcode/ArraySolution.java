package com.hua.algorithm.service.leetcode;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/8/22<p>
//-------------------------------------------------------
public class ArraySolution {
    /**
     * 寻找着中心索引
     * */
    public int pivotIndex(int[] nums) {
        if(nums==null){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum +=nums[i];
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftSum = 0;
            }else{
                leftSum += nums[i-1];
            }

            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    /**
     * 最大元素至少是其他数据的二倍
     * */
    public int dominantIndex(int[] nums) {
        if(nums==null){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }
        int max=Integer.MIN_VALUE;  //最大数
        int second=Integer.MIN_VALUE;//第二大的数
        int index=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>max) {
                max=nums[i];
                index=i;
            }
        }
        for(int i:nums) {
            if(i>second&&i<max) {
                second=i;
            }
        }
        if(second*2<=max) {
            return index;
        }

        System.out.println(max+" "+second);
        return -1;
    }

    /**
     * 数组加1
     * */
    public int[] plusOne(int[] digits) {
        if(digits==null){
            return digits;
        }
        int ci= 0;
        for(int i=digits.length-1;i>=0;i--){
            int value = 0;
            if (i==digits.length-1) {
                value = (digits[i]+1+ci)%10;
                ci = (digits[i]+1+ci)/10;
            }else{
                value = (digits[i]+ci)%10;
                ci = (digits[i]+ci)/10;
            }
            digits[i] = value;
        }
        if(ci==0){
            return digits;
        }
        int[] result = new int[digits.length+1];
        result[0] = ci;
        for(int i=0;i<digits.length;i++){
            result[i+1] = digits[i];
        }
        return result;
    }

    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        ArraySolution arraySolution = new ArraySolution();

/*        int[] a = {-1,-1,-1,-1,-1,0};
        arraySolution.pivotIndex(a);*/

/*        int[] a = {0,2,0,3};
        int index = arraySolution.dominantIndex(a);
        System.out.println("index==>"+index);*/

/*        int[] a = {8,9,9};
        arraySolution.plusOne(a);*/

        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }
}
