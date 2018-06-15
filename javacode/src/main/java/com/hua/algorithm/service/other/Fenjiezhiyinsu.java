package com.hua.algorithm.service.other;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/23<p>
// -------------------------------------------------------
public class Fenjiezhiyinsu {
    public static void main(String[] args) {
        int testNum = 8;
        function(testNum);

        int score = 90;
        String scoreLevel = divideScore(score);
        System.out.printf("scoreLevel="+scoreLevel);

        System.exit(0);

    }

    private static void function(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf(String.valueOf(i));

                if (num != i) {
                    System.out.printf("*");
                }
                function(num / i);
            }
        }
    }

    private static String divideScore(int score) {
        return score >= 90 ? "A" : (score > 60 && score <= 89) ? "B" : "C";
    }
}
