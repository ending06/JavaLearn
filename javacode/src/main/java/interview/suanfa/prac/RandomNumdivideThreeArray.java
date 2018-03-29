package interview.suanfa.prac;


// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/28<p>
// -------------------------------------------------------
public class RandomNumdivideThreeArray {


    private static int minValue = -1;

    private static int a[] = { 1, 2, 4, 3,10,35,22 };

    private static int b[] = new int[a.length];

    private static int f[] = new int[a.length];


    public static void main(String[] args) {


        int count[] = new int[3];

        int index = 0;

        function(a, index, a.length, b, count);

        System.out.println("==========================>");

        System.out.println("给定的任意数组为:");
        for(int k=0;k<a.length;k++){
            System.out.printf(" "+a[k]+" ");
        }
        System.out.println("");

        System.out.println("最终minValue:" + minValue + "===>最终确认分组为:");
        for(int k=0;k<a.length;k++){
            System.out.printf(" "+f[k]+" ");
        }


    }

    private static void function(int[] a, int index, int length, int[] b, int[] count) {
        if (index == (length-1)) {
            for (int j = 0; j < 3; j++) {
                // 加入到第j列数组
                count[j] += a[index];
                b[index] = j;
                computeValue(count);
                count[j] -= a[index];
            }
        } else {
            for (int j = 0; j < 3; j++) {
                count[j] += a[index];
                b[index] = j;
                function(a, index + 1, length, b, count);
                count[j]-=a[index];
            }
        }
    }

    private static void computeValue(int[] count) {
        int tempValue = sum(count);

        if (minValue == -1) {
            minValue = tempValue;
            System.out.printf("首次分组为minValue:"+minValue+"===>首次分组为:");
            for(int k=0;k<a.length;k++){
                System.out.printf(" " + b[k]+" ");
            }
            System.out.println("");
        } else {
            if (tempValue < minValue) {
                minValue = tempValue;
                System.out.printf("当前匹配成功的minValue:"+minValue+"===>当前匹配成功的分组为:");
                for(int k=0;k<a.length;k++){
                    System.out.printf(" "+b[k]+" ");
                    f[k] = b[k];
                }
                System.out.println("");
            }
        }
    }

    private static int sum(int[] count) {
        int a = count[0];
        int b = count[1];
        int c = count[2];
        int subValue1 = a > b ? (a - b) : (b - a);
        int subValue2 = b > c ? (b - c) : (c - b);
        int subValue3 = a > c ? (a - c) : (c - a);
        return subValue1 + subValue2 + subValue3;
    }

}
