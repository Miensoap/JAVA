package DataSt;

import java.util.ArrayList;

public class Main {
    static String str = "Example";
    static int i = 1234;

    public static void main(String[] args) {
        Boolean startsWithEX = str.startsWith("E");
        Boolean endsWithEx = str.endsWith("e");
        Boolean equalEx = str.equals("E");
        Boolean containsEx = str.contains("Ex");

        String substringEx = str.substring(0,1);
        String replaceEx = str.replace('E','A');
        String lowerCaseEx = str.toLowerCase();
        String upperCaseEx = str.toUpperCase();
        String trimEx = str.trim();

        int indexOfEx = str.indexOf('E');
        char charAtEx = str.charAt(1);
        String valueOfEx = String.valueOf(i);
        String[] splitEx = str.split("");
        int lengthEx = str.length();

    }
}
