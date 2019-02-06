import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HE3 {
public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int testNum = sc.nextInt();
    Set<Integer> hSet = new HashSet<>();
    for (int i = 0 ; i < testNum ; i++) {
        long N  = sc.nextLong();
        ArrayList<int[]> list = new ArrayList<>();
    for (int j = 0; j < N ;j++) {
        int[] arr = new int[2];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        list.add(arr);
       
        }
    System.out.println(getContinousSum(hSet, list));
    }
}

private static int getContinousSum(Set<Integer> hSet, ArrayList<int[]> list) {
    int max_sum  = 0;int sum = 0;
    int prev_sum = 0;
    for(int[] arr : list) {
       int index = arr[0];
       int val = arr[1];
       if (val == 0) {
           prev_sum = sum;
           sum = 0;
           hSet.add(index);
       } else {
           
           sum  = sum + 1;  
           if (hSet.contains(index)) {
               sum = sum - 1;
           }
       }
       max_sum = Math.max(sum, prev_sum);
    }
    return max_sum;
}
}
