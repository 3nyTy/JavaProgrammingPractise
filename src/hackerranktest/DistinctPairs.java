package hackerranktest;

import java.util.HashSet;
import java.util.*;

public class DistinctPairs {
    static int numberOfPairs(int[] a, long k) {
        Map<Integer, Integer> pairsMap = new HashMap<>();
        Set<Integer> pairSet = new HashSet<Integer>();
        for (int num : a) { 
            pairSet.add(num);
        }
        
        for (int num : a) {
            int complement = (int) (k - num);
            if(pairSet.contains(complement) && !pairsMap.containsKey(complement)) {
                pairsMap.put(num, complement);
            }
        }
        return pairsMap.size();
    }
    
    public static void main(String[] args) {
      int res =  DistinctPairs.numberOfPairs(new int[] {1, 3,45,1,24,43}, 46);
      System.out.println(res);
    }
}
