package microsoft;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public static void main(String[] args) {
        int[] inp = new int[] {
                1, 2, 3
        };
        generateSubsets(inp);
    }

    private static void generateSubsets(int[] inp) {
        List<List<Integer>> out = new ArrayList<>();
        backTrack(inp, 0, new ArrayList<>(), out);

    }

    private static void backTrack(int[] inp, int start, ArrayList temp, List<List<Integer>> out) {
        if (start == inp.length) {
            System.out.println(temp.toString());
            out.add(temp);
            return;
        }

        temp.add(inp[start]);
        backTrack(inp, start + 1, temp, out);
        temp.remove(temp.size() - 1);
        backTrack(inp, start + 1, temp, out);

    }

}
