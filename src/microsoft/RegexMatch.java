package microsoft;

public class RegexMatch {
public static void main(String[] args) {
    System.out.println(isRegexMatchTwoString("Gowriiiiiii", "G.wri*"));
}

private static boolean isRegexMatchTwoString(String text, String pattern) {
    boolean[][] T = new boolean[text.length() + 1][pattern.length() + 1];
    
    T[0][0] = true;
    
    //for patterns a*, a*b*
    for (int i = 1; i < T[0].length; i++) {
        if (pattern.charAt(i - 1) == '*') {
            T[0][i] =  T[0][i-2];
        }
    }
    
    for (int r = 1; r < T.length; r++) {
        for (int c = 1; c < T[0].length; c++) {
            if(pattern.charAt(c-1) == text.charAt( r - 1) || pattern.charAt(c - 1) == '.' ) {
                T[r][c] = T[r - 1][c - 1];
            } else if (pattern.charAt(c - 1) == '*' ) {
                T[r][c] = T[r][c - 2];
                if(pattern.charAt(c - 2) == '.' || pattern.charAt(c - 2) == text.charAt(r - 1)) {
                    T[r][c] = T[r - 1][c] || T[r][c];
                }
            } else {
                T[r][c] = false;
            }
            
        }
    }
    
    return T[text.length()][pattern.length()];
}
}
