package utils;

public class StringUtils {
     public static final String NEWLINE = System.getProperty("line.separator");

     public static String appendNewLine(String origin){
          return origin+NEWLINE;
     }

     private StringUtils(){}
}
