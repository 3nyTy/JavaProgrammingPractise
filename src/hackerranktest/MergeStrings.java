package hackerranktest;
import java.util.*;

public class MergeStrings {
    public static void main(String[] args) {
        String a = "jygfk";
        String b = "kugyfdud";

        System.out.println(mergedString(a, b));
    }

    public static String mergedString(String a, String b) {
        List<Character> aCharList = new ArrayList<>();
        List<Character> bCharList = new ArrayList<>();

        char[] aChars = a.toCharArray();
        for(char aChar : aChars) {
            aCharList.add(aChar);
        }

        char[] bChars = b.toCharArray();
        for(char bChar : bChars) {
            bCharList.add(bChar);
        }

        Iterator<Character> aIter = aCharList.iterator();
        Iterator<Character> bIter = bCharList.iterator();
        StringBuilder sbr = new StringBuilder();

        while (aIter.hasNext() || bIter.hasNext()) {
            if (aIter.hasNext()) {
                sbr.append(aIter.next());
            }

            if (bIter.hasNext()) {
                sbr.append(bIter.next());
            }
        }

        return sbr.toString();
    }
}
