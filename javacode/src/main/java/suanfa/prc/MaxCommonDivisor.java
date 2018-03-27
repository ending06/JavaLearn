package suanfa.prc;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/23<p>
// -------------------------------------------------------
public class MaxCommonDivisor {
    private static int reminderOneValue = 1;
    private static int reminderTwoValue = 1;

    private static int maxCommonDivisor = 1;

    public static void main(String[] args) {
        int oneNum = 6;
        int twoNum = 9;

        findDivisor(oneNum, twoNum);

        System.out.println("最大公约数=" + maxCommonDivisor);

        System.out.println("最小公倍数=" + (maxCommonDivisor * reminderOneValue * reminderTwoValue));

    }

    private static void findDivisor(int oneNum, int twoNum) {
        if (oneNum == 1 || twoNum == 1) {
            reminderOneValue = oneNum;
            reminderTwoValue = twoNum;
            return;
        }
        int endValue = oneNum > twoNum ? twoNum : oneNum;
        for (int i = 2; i <= endValue; i++) {
            if ((oneNum % i == 0) && (twoNum % i == 0)) {
                System.out.println("i=" + i);
                maxCommonDivisor = maxCommonDivisor * i;
                findDivisor(oneNum / i, twoNum / i);
                break;
            } else if (i == endValue) {
                System.out.println("oneNum=" + oneNum + ";twoNum=" + twoNum);
                reminderOneValue = oneNum;
                reminderTwoValue = twoNum;
            }
        }
    }
}
