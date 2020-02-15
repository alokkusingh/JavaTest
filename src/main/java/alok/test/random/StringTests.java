package alok.test.random;

import java.util.*;

public class StringTests {
    public static int getLongestUniqueSubString(String str) {

        if (str == null) {
            return 0;
        }
        Set<Character> distinctChars = new HashSet<>();

        for (Character ch: str.toLowerCase().toCharArray()) {
           distinctChars.add(ch);
        }

        return distinctChars.size();
    }

    public static String getStringLexicographicallySorted(String string1, String string2, String string3) {
        List<String> stringList = Arrays.asList(string1, string2, string3);

        stringList.sort((str1, str2) -> {
            if (str1 == null || str2 == null) {
                return 0;
            }
            return str1.compareToIgnoreCase(str2);
        });

        return stringList.stream().reduce("", (str1, str2) -> (str1 == null ? "" : str1) + (str2 == null ? "" : str2));
    }
}
