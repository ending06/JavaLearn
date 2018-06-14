package interview.suanfa.prac;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/13<p>
// =====================delK个连续0=======================
// -------------------------------------------------------
public class KNumZero {

    public static void main(String[] args) {
        int k = 3;
        String inputStr = "A0000B000C000";

        String result = removeKZeros(inputStr, k);
        // A0000B   C   
        System.out.println("delK个连续0==>" + result);
    }

    public static String removeKZeros(String str, int k) {

        if (str == null || k < 1) {
            return str;
        }

        char[] chas = str.toCharArray();
        int count = 0, start = -1;

        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;

            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chas[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }

        if (count == k) {
            while (count-- != 0) {
                chas[start++] = 0;
            }
        }
        String result = String.valueOf(chas);
        // String.valueof===>A0000B   C   ;长度=13
        System.out.println("String.valueof===>" + result + ";长度=" + result.length());
        return result;
    }
}
