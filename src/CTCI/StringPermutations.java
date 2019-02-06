package CTCI;

import java.util.ArrayList;
import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        findAllPermutationsForString(str);
    }

    private static void findAllPermutationsForString(String str) {
        // TODO Auto-generated method stub
        
        ArrayList<String> results = new ArrayList<>();
        getPermutations("", str, results); 
        //results.stream().forEach((x) -> System.out.println(x));
        //System.out.println();
    }

    private static void getPermutations(String prefix, String suffix, ArrayList<String> results) {
        System.out.println("Entering recursion here with : " + " PREFIX - " + prefix + ", Suffix : " + suffix );
        if (suffix.length() ==0) {
            System.out.println("BaseCase");
            System.out.println(prefix);
            results.add(prefix);
            System.out.println("*********************");
        } else {
        for (int i = 0; i < suffix.length(); i++) {
           // System.out.println("Start Of the loop each time");
            //System.out.println(prefix + suffix.charAt(i));
            //System.out.println( suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
            getPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
        }
            
        }
    }
}
