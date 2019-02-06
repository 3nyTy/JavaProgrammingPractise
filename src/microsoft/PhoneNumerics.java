package microsoft;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumerics {
    
   static String[] phone = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    
    public static void main(String[] args) {
        List<String> out = findAllCombinationsofPhoneNo("234");
        out.stream().forEach(System.out::println);
    }

    private static List<String> findAllCombinationsofPhoneNo(String inp) {
        List<String> out = new ArrayList<>();
        findAllCombinations ("", inp, 0, out);
        return out;
    }

    private static void findAllCombinations(String combinedStr, String inp, int offset, List<String> out) {
       if (offset >= inp.length()) {
           out.add(combinedStr);
           return;
       }
       
       String letters = phone[inp.charAt(offset) - '0'];
       
       for(int i = 0 ; i < letters.length(); i++) {
           findAllCombinations(combinedStr + letters.charAt(i), inp, offset + 1, out);
       }
       
        
    }

}
