package suanfa.prc;

import java.util.Scanner;
import java.util.regex.Pattern;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/27<p>
// -------------------------------------------------------
public class CountCharacterAndNum {

    private static final String characterParrern = "[a-zA-z]+";

    private static final String digitPattern = "[0-9]+";

    private static final String whiteBlanPattern = "\\s";

    public static void main(String[] args) {

        int chacterCount = 0;
        int digitCount = 0;
        int whiteBlankCount = 0;
        int otherCount = 0;

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        char[] valueList = line.toCharArray();

        int lengthSize = valueList.length;

        for (int i = 0; i < lengthSize; i++) {
            if (isCharacter(valueList[i])) {
                chacterCount++;
            } else if (isDigit(valueList[i])) {
                digitCount++;
            } else if (isWhiteBlank(valueList[i])) {
                whiteBlankCount++;
            } else {
                otherCount++;
            }
        }

        System.out.printf("字母=" + chacterCount + ";数字" + digitCount + ";空格=" + whiteBlankCount + ";其他=" + otherCount);
    }

    private static boolean isWhiteBlank(char c) {
        Pattern pattern = Pattern.compile(whiteBlanPattern);
        return pattern.matcher(String.valueOf(c)).matches();
    }

    private static boolean isDigit(char c) {
        Pattern pattern = Pattern.compile(digitPattern);
        return pattern.matcher(String.valueOf(c)).matches();
    }

    private static boolean isCharacter(char c) {
        Pattern pattern = Pattern.compile(characterParrern);
        return pattern.matcher(String.valueOf(c)).matches();
    }

}
