package com.hua.algorithm.service.other;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/23<p>
// -------------------------------------------------------
public class PrimeNumber {
    public static void main(String[] args) {
        choosePrimeNumber();
    }

    private static void choosePrimeNumber() {
        for (int i = 1; i <= 100; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.printf(i + ";");
            }
        }
    }
}
