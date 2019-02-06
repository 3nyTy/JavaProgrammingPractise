package hackerranktest;

import java.util.*;

public class MissingWords {
    public static void main(String[] args) {
        String s = "I like programming on Hacker Rank";
        String t = "like on Rank";
        
        List<String> missing = missingWords(s, t);
        missing.stream().forEach(m -> System.out.println(m));
    }
    
    public static List<String> missingWords(String s, String t) {
        List<String> missingWords = new ArrayList<>();
        String sWords[] = s.split(" ");
        String tWords[] = t.split(" ");
        int i=0, j=0;
        
        for(;i < sWords.length && j<tWords.length;) {
            if (sWords[i].equals(tWords[j])) {
                i++;
                j++;
            } else {
                missingWords.add(sWords[i]);
                i++;
            }
        }
        
       /* 
        List<String> sWords = Arrays.asList(s.split(" "));
        List<String> tWords = Arrays.asList(t.split(" "));
        
        Iterator<String> sIter = sWords.iterator();
        Iterator<String> tIter = tWords.iterator();
        
        while(tIter.hasNext()) {
            String tWord = tIter.next();
            boolean match = false;
            do {
                String sWord = sIter.next();
                if(!tWord.equals(sWord)) {
                    missingWords.add(sWord);
                } else {
                    match = true;
                }
            } while(!match);
        }
        
        while(sIter.hasNext()) {
            missingWords.add(sIter.next());
        }
     */   
        return missingWords;
    }
}
