package amazomn;

import java.util.Map.Entry;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class TrieNode{
    char ch;
    boolean isEnd;
    List<Integer> positions = new ArrayList<>();
    Map<Character,TrieNode> children=new TreeMap<>();
    TrieNode(){};
    TrieNode(char ch) {
        this.ch = ch;
    }
    
}
class Trie{
    TrieNode root = new TrieNode();
    boolean contains(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) {
           TrieNode next = curr.children.get(ch);
           if(next == null) return false;
           else curr = next;
        }
        return curr.isEnd;
        
    }
    
    List<Integer> getItem(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            TrieNode next = curr.children.get(ch);
            if (next == null) {
                next = new TrieNode(ch);
                curr.children.put(ch, next);
            }
            curr = next;
        }
        curr.isEnd = true;
        return curr.positions;
        
    }
    
    void print(){
        List<TrieNode> l = new ArrayList<>();
        l.add(root);
        output(l,"");
    }
    
    void output(List<TrieNode> currPath, String indent) {
        TrieNode curr = currPath.get(currPath.size() -1);
        if (curr.isEnd) {
            String word = "";
            for (TrieNode n : currPath) {
                word += n.ch;
            }
            System.out.println(indent + word + "" + curr.positions);
            indent += " ";
        }
        for(Entry<Character, TrieNode> hm : curr.children.entrySet()) {
            TrieNode node = hm.getValue();
            List<TrieNode> newList = new ArrayList<>();
            newList.addAll(currPath);
            newList.add(node);
            output(newList, indent);
        }
    }
 
}

public class FindWordPositionInText {
   public static void main(String[] args) {
       String text = readFile("TrieTest.txt");
       String[] words = getWords(text);
       Trie t = createIndex(words);
       t.print();
      
       printPositions(t,"of");
   }
  
   static void printPositions(Trie t,String s){
       if(t.contains(s)){
           System.out.println(s+": "+t.getItem(s));
       }
   }
  
   static Trie createIndex(String[] words){
       Trie t = new Trie();
       for(int i=0;i<words.length;i++){
           t.getItem(words[i]).add(i);
       }
       return t;
   }
  
   static String[] getWords(String text){
       return text.toLowerCase().split(" ");
   }
  
   static String readFile(String filename){
       StringBuilder sb = new StringBuilder();
       try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename), Charset.defaultCharset())){
           String line = null;
           while ( (line = reader.readLine()) != null ) {sb.append(line);}
       }catch(Exception e){e.printStackTrace();}
       return sb.toString();
   }
}
