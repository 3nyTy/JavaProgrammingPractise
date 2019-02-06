package hackerranktest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RangeInArray {

    /*
     * Complete the function below.
     */
    static int findNumbersInRange(int[] scores, int startLimit, int endLimit) {
        int count = 0;
        int low = 0; int high = scores.length -1;
       
       while (low < high) {
            if (startLimit > scores[low]) {
                low = low + 1;
            } else if (endLimit < scores[high]) {
                high = high - 1;
            } else {
                break;
            }
        }

        return high - low + 1;

    }

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int firstLength = lowerLimits.length;
        int secondLength = upperLimits.length;
        int[] output = new int[firstLength];

        if (firstLength == 0 && secondLength == 0) {
            return scores;
        } else if (lowerLimits.length == upperLimits.length) {
            for (int i = 0; i < lowerLimits.length; i++) {
                output[i] = findNumbersInRange(scores, lowerLimits[i], upperLimits[i]);
                System.out.println(output[i]);
            }
        }

        return output;

    }

    public static void main(String[] args) throws IOException {
        
        RangeInArray.jobOffers(new int[] {1,3,5,6,8}, new int[] {2},new int[] {6});
    }
}
