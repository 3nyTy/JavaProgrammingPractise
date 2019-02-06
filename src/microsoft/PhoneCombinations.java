package microsoft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneCombinations {
    public static void main(String[] args) {
        String num = "23";
        List<String> strList = findAllPossibleCombinations(num);
        
        Map<String, String> phoneMap = new HashMap<String, String>(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
          }};
        
    }

    private static List<String> findAllPossibleCombinations(String num) {
        if (num.length() != 0) {
            backTrack("", num);
        }
        
        return null;
    }

    private static void backTrack(String combination, String next_digits) {
        
        if(next_digits.length() == 0) {
            
        }
        
    }
}
