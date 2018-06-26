package com.hua.algorithm.service.Str.utils;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/22<p>
// -------------------------------------------------------
public class StrMainTest {
    public static void main(String[] args) {
        // String s=”aaabbadddffc”;其统计字符串形式为”a_3_b_2_a_1_d_3_f_2_c_1“
        StringTools.stastatistic("aaabbadddffc");

        //字符串替换str="123abcabc" from = "abc" to ="X" 返回123X,连续出现的话to一个
        StringTools.replaceFromToStr("123adcabc", "abc", "X");
    }
}
