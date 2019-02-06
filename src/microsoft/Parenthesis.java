package microsoft;

import java.util.ArrayList;
import java.util.List;

//TC : 4^n/(n * Math.pow(n, 0.5))
public class Parenthesis {
    public static void main(String[] args) {
        List<String> out = generateParenthesis(3);
        out.stream().forEach(System.out::println);
        
    }

    private static List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        backTrack("", n, n, out);        
        return out;
    }

    private static void backTrack(String bracketStr, int left, int right, List<String> out) {
        if (left > right) {
            return;
        }
               
        if(left > 0) {
            backTrack(bracketStr + "(", left - 1, right, out);
        }
        
        if(right > 0) {
            backTrack(bracketStr + ")", left, right - 1, out);
        }
        
        if(left == 0 && right == 0) {
            out.add(bracketStr);
            return;
        }
        
        
    }
    

}
