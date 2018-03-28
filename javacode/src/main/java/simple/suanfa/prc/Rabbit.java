package simple.suanfa.prc;


import java.util.Scanner;
import java.util.regex.Pattern;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/223<p>
// -------------------------------------------------------
public class Rabbit {

    private static final String INT_PATTERN = "[0-9]*";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();

        Pattern pattern = Pattern.compile(INT_PATTERN);

        if(!pattern.matcher(num).matches()){
            throw new Exception("输入字符非法");
        }

        System.out.printf("第num=" + num + "的个数为：" + function(Integer.parseInt(num)));
    }

    private static int function(int num) {
        if (num==1||num==2) {
            return 1;
        }
        return function(num-1)+function(num-2);
    }
}
