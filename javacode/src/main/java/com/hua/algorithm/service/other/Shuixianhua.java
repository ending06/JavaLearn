package com.hua.algorithm.service.other;

import java.util.Scanner;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/23<p>
// -------------------------------------------------------
public class Shuixianhua {
    public static void main(String[] args) throws Exception {
        int startNum = 100;
        int endNum = 999;

        findShuiXianHuaNum(startNum, endNum);
    }

    private static void findShuiXianHuaNum(int startNum, int endNum) throws Exception {
        if (startNum > endNum) {
            throw new Exception("输入参数不合法");
        }
        for (int i = startNum; i <= endNum; i++) {
            int baiwei = i / 100;

            int shiwei = (i % 100) / 10;

            int gewei = i % 10;

            if(i==(baiwei*baiwei*baiwei+shiwei*shiwei*shiwei+gewei*gewei*gewei)){
                System.out.println("满足预期水仙花数="+i);
                continue;
            }
        }
    }
}
