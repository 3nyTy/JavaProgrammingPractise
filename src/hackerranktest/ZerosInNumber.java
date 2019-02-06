package hackerranktest;
import java.util.*;

public class ZerosInNumber {

        /*
         * Complete the 'countHoles' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER num as parameter.
         */
        static Map<Integer, Integer> holesMap = new HashMap<Integer,Integer>();
        public static void main(String[] args) {
            holesMap.put(1, 0);
            holesMap.put(2, 0);
            holesMap.put(3, 0);
            holesMap.put(4, 0);
            holesMap.put(5,0);
            holesMap.put(6, 1);
            holesMap.put(7, 0);
            holesMap.put(8, 2);
            holesMap.put(9, 1);
            
        }
        
        public static int countHoles(int num) {
        String temp = Integer.toString(num);
        int sum = 0;
        int[] newNum = new int[temp.length()];
        for (int i = 0; i < newNum.length; i++) {
            newNum[i] = temp.charAt(i) - '0';
            sum += holesMap.get(newNum[i]);

        }
        return sum;
        }
        
    }
