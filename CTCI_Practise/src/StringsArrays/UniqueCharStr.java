package StringsArrays;

import java.util.Scanner;

//BruteForce - Sort and Compare (O(n logn))
//Below : TC - O(n)
public class UniqueCharStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkStrContainsUniqueChar(str));
    }

    private static boolean checkStrContainsUniqueChar(String str) {
        if (str.length() > 128)
            return false;
        boolean[] arr = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (arr[val])
                return false;
            arr[val] = true;
        }
        return true;

    }
}
