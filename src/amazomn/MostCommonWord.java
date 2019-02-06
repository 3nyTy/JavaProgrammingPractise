package amazomn;

import java.util.StringTokenizer;

import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MostCommonWord {

        public static String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = new HashSet<>();
            for (String word : banned) {
                if (word != null) {
                bannedSet.add(word.toLowerCase());
                }
            }
            Map<String, Integer> hm = new HashMap<>();
        StringTokenizer str = new StringTokenizer(paragraph, "[ !?',;.]+");
            while(str.hasMoreTokens()) {
                String newStr = str.nextToken().toLowerCase();
                if(newStr.contains(",") || newStr.contains(".")) {
                    newStr = newStr.substring(0, newStr.length() - 1);
                }
                if (!bannedSet.contains(newStr)){
                    if (hm.containsKey(newStr)){
                        hm.put(newStr, hm.get(newStr) + 1);
                    } else {
                        hm.put(newStr, 1);
                    }
                    
                }
            }
            int maxCount = 0; String result = "";
            for(Map.Entry<String, Integer> entry : hm.entrySet()) {
                if(maxCount < entry.getValue()) {
                    result = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
           return result; 
        }
       
        public static void main(String[] args) throws IOException {
            String input = "Bob hit a ball, the hit BALL flew far after it was hit." ;
            String[] banned = new String[]{"hit"};
            String out = MostCommonWord.mostCommonWord(input, banned);
            System.out.println(out);
            System.out.println(new StringBuilder("Str!"));
        }
        
    }

    

