package interview.suanfa.prac;

import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.Collections;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/13<p>
// -------------------------------------------------------
public class CharacterVariable {
    public static void main(String[] args) {
        boolean result = isVariable("123", "2314");
        System.out.printf("result===>" + result);
    }

    private static boolean isVariable(String str1, String str2) {
        Map<String, Integer> countFirstMap = parseStr(str1);
        Map<String, Integer> countSecondMap = parseStr(str2);

        if (null == countFirstMap || countFirstMap.isEmpty() || null == countSecondMap || countSecondMap.isEmpty()) {
            return false;
        }
        if (countFirstMap.size() != countSecondMap.size()) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : countFirstMap.entrySet()) {
            if (Ints.compare(entry.getValue(), countSecondMap.get(entry.getKey())) != 0) {
                return false;
            }
        }
        return true;

    }

    private static Map<String, Integer> parseStr(String inputStr) {
        if (null == inputStr || "".equals(inputStr)) {
            return Collections.emptyMap();
        }
        char[] strArray = inputStr.toCharArray();
        Map<String, Integer> countMap = Maps.newHashMapWithExpectedSize(strArray.length);
        for (int i = 0; i < strArray.length; i++) {
            if (countMap.get(String.valueOf(strArray[i])) == null) {
                countMap.put(String.valueOf(strArray[i]), 1);
            } else {
                countMap.put(String.valueOf(strArray[i]), countMap.get(String.valueOf(strArray[i])) + 1);
            }
        }
        return countMap;
    }
}
