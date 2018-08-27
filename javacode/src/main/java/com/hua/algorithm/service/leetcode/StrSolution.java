package com.hua.algorithm.service.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/8/22<p>
// -------------------------------------------------------
public class StrSolution {
    /**
     * 二进制求和
     * */
    public String addBinary(String a, String b) {
        if (a == null || a == "") {
            return b;
        }
        if (b == null || b == "") {
            return a;
        }
        char[] ay = a.toCharArray();
        char[] by = b.toCharArray();

        int al = ay.length;
        int bl = by.length;
        int max = al > bl ? al : bl;

        int[] newStr = new int[max+1];
        int ci = 0;
        for (; max >= 0; max--) {
            if (al > 0 && bl > 0) {
                int avalue = ay[al - 1] - '0';
                int bvalue = by[bl - 1] - '0';
                int value = (avalue + bvalue + ci) % 2;
                ci = (avalue + bvalue + ci) / 2;
                newStr[max] = value;
                al--;
                bl--;
            } else if (al <= 0 && bl > 0) {
                int bvalue = by[bl - 1] - '0';
                int value = (bvalue + ci) % 2;
                ci = (bvalue + ci) / 2;
                newStr[max] = value;
                bl--;
            } else if (bl <= 0 && al > 0) {
                int avalue = ay[al - 1] - '0';
                int value = (avalue + ci) % 2;
                ci = (avalue + ci) / 2;
                newStr[max] = value;
                al--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (ci != 0) {
            stringBuilder.append(ci);
        }
        for(int i=1;i<newStr.length;i++){
            stringBuilder.append(newStr[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * haystack = "hello", needle = "ll"  return 2
     *
     * haystack = "aaaaa", needle = "bba" return -1
     * */
    public int strStr(String haystack, String needle) {
        if(haystack==null||haystack==""||needle==null){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for(int i =0;i<source.length;i++){
            if(source[i]==target[0]){
                if(isRealMatch(source,i,target)){
                    return i;
                }
            }
        }
        return -1;

    }

    /**
     * 最长公共前缀 ["flower","flow","flight"]==> fl
     *
     * ["dog","racecar","car"]
     *
     * */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String cur = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(cur)!=0){
                cur = cur.substring(0,cur.length()-1);
            }
        }
        return cur;
    }

    /**
     * 输入: "hello"  输出: "olleh"
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: "amanaP :lanac a ,nalp a ,nam A"
     * */
    public String reverseString(String s) {
        if(s==null||s.length()==0||s.length()==1){
            return s;
        }
        char[] sy = s.toCharArray();
        int i = 0;
        int j = sy.length-1;
        while(j>=i){
            char temp = sy[i];
            sy[i] = sy[j];
            sy[j] = temp;
            i++;
            j--;
        }

        return new String(sy);
    }

    private boolean isRealMatch(char[] source, int i, char[] target) {
        int init = 0;
        int j = i;
        while(init<target.length){
            if(j>=source.length){
                return false;
            }
            if(target[init]!=source[j]){
                return false;
            }
            init++;
            j++;
        }
        return true;
    }

    public int arrayPairSum(int[] nums) {
        if(nums==null){
            return -1;
        }
        Arrays.sort(nums);

        int maxSum = 0;
        int i =0;
        while(i<nums.length){
            maxSum +=nums[i];
            i = i+2;
        }
        return maxSum;
    }

    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null){
            return null;
        }
        int[] result=new int[2];
        int len=numbers.length;
        int i = 0;
        int j = len-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                result[0] = i+1;
                result[1] = j+1;
                break;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=val;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        StrSolution strSolution = new StrSolution();

/*        String a = "0";
        String b = "0";
        String result = strSolution.addBinary(a, b);
        System.out.println("result===>" + result);*/

/*        String aa = "a"; String bb = "";
        int result = strSolution.strStr(aa,bb);
        System.out.println("result====>"+result);*/

/*        String[] str = {"flower","flow","flight"};
        strSolution.longestCommonPrefix(str);*/

/*        String aa = "h12";
        String result = strSolution.reverseString(aa);
        System.out.println("result===="+result);*/

/*        int[] aa = {1,4,3,2};
        int result = strSolution.arrayPairSum(aa);
        System.out.println("result===>"+result);*/
/*        int[] aa = {2, 7, 11, 15};
        int[] result = strSolution.twoSum(aa,9);
        System.out.println("result===>"+result);*/
        int[] aa = {0,1,2,2,3,0,4,2};
        int length = strSolution.removeElement(aa,2);
        System.out.println("length===>"+length);
    }
}
