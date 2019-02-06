package amazomn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadderBFS {
    public static int ladderLength(String start, String end, Set<String> dict) {
        if (!dict.contains(end)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);

        Set<String> visited = new HashSet<>();

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);
                        System.out.println(word);

                        if (word.equals(end))
                            return level + 1;

                        if (dict.contains(word) && !visited.contains(word)) {
                           System.out.println("*********************");
                            System.out.println("The word is : " +word );
                            queue.add(word);
                            visited.add(word);
                        }

                    }
                }
            } else {
               System.out.println("The level is : " +level);
                level ++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        // ["hot","dot","dog","lot","log","cog"]
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        int out = ladderLength("hit", "cog", dict);

        System.out.println(out);
    }
}
