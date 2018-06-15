package com.hua.algorithm.service.other;


// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/13<p>
// A-1BC--12
// -------------------------------------------------------
public class SumNum {
    public static void main(String[] args) {
        String input = "A-1bc--123";
        int sum = numSum(input);
        System.out.printf("result===>" + sum);
    }

    public static int numSum(String str){
        if(str == null){
            return 0;
        }
        char[] charArr = str.toCharArray();

        int res =0;

        int num = 0;

        boolean flag = true;

        int cur = 0;

        for(int i=0; i< charArr.length; i++){

            cur = charArr[i] - '0';

            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(charArr[i] == '-'){
                    if(i - 1 > -1 && charArr[i - 1] == '-'){
                        flag = !flag;
                    }else {
                        flag = false;
                    }
                } else {
                    flag = true;
                }
            } else {
                num = num * 10 + (flag ? cur : -cur);
            }
        }
        res += num;
        return res;
    }
}
