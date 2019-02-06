package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> output = permute(new int[] {
                1, 2, 3
        });
        output.stream().forEach(x -> {
            System.out.println(x.toString());
        });

        List<String> results = permuteString("abc");
        results.stream().forEach(System.out::println);
    }

    private static List<String> permuteString(String input) {
        List<String> res = new ArrayList<String>();
        backTrackString("", input, res);
        return res;
    }

    private static void backTrackString(String prefix, String suffix, List<String> res) {
        if (suffix.length() == 0) {
            res.add(prefix);
            return;
        } else {

            for (int i = 0; i < suffix.length(); i++) {
                backTrackString(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix
                        .length()), res);
            }
        }

    }   

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);
        generateAllPerms(nums_lst, 0, output);
        return output;
    }

    public static void generateAllPerms(ArrayList<Integer> nums, int start, List<List<Integer>> out) {
        if (start == nums.size()) {
            System.out.println(nums.toString());
            out.add(nums);
            return;
        } else {

            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums, start, i);
                generateAllPerms(nums, start + 1, out);
                Collections.swap(nums, start, i);
            }
        }
    }
}
