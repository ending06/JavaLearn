package com.hua.algorithm.service.Str.utils;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/22<p>
// -------------------------------------------------------
public class StringTools {
    /**
     *
     * 给定一个字符串str,返回其统计字符串，例如String s=”aaabbadddffc”;其统计字符串形式为”a_3_b_2_a_1_d_3_f_2_c_1“。
     * */
    public static void stastatistic(String inputStr) {
        if (null == inputStr || inputStr.length() == 0) {
            return;
        }
        char[] chars = inputStr.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == (chars.length - 1)) {
                count++;
                System.out.printf(chars[i] + "_" + count);
                count = 0;
                break;
            }
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                count++;
                System.out.printf(chars[i] + "_" + count + "_");
                count = 0;
            }
        }
    }

    /**
     * 字符串替换str="123abcabc" from = "abc" to ="X" 返回123X,连续出现的话to一个
     * */
    public static void replaceFromToStr(String sourceStr, String fromStr, String toStr) {
        if (StringUtils.isBlank(sourceStr) || StringUtils.isBlank(fromStr) || StringUtils.isBlank(toStr)) {
            return;
        }
        char[] source = sourceStr.toCharArray();
        char[] from = fromStr.toCharArray();

    }
}
