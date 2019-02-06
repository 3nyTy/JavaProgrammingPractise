import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Practise {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "cdl", "", "", "jkl");
        List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        List<String> parFilter = strings.parallelStream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        Java8Practise.printList(parFilter);
        Java8Practise.printList(filtered);
        List<Integer> ints = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = ints.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        Java8Practise.printList(ints);
        StringTokenizer styr = new StringTokenizer("");
        System.out.println("*************");
        
        System.out.println(IntStream.range(1, 10).
        sum());
        System.out.println();
        
        Stream.of("Ava", "Aneri", "Alberto")
        .sorted()
        .findFirst()
        .ifPresent(System.out::println);
        
        List<String> people = Arrays.asList("Al", "Ankit","Ben","Sarika", "Amanda", "Hans");
        people.stream()
        .map(String::toLowerCase)
        .filter(x -> x.startsWith("a"))
        .forEach(System.out::println);
        
        
        try {
            Stream<String> rows1  = Files.lines(Paths.get("StreamEx.txt"));
            Map<String, Integer> mp = new HashMap<>();
            mp = rows1.map( x -> x.split(","))
            .filter(x -> x.length == 3)
            .filter(x -> Integer.parseInt(x[1]) > 2)
            .collect(Collectors.toMap(
                    x -> x[0], x -> Integer.parseInt(x[1]))
                    );
            rows1.close();
            
            for(String monkey : mp.keySet()) {
                System.out.println("Map key is : "+ monkey);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("**********");
        Map<String, Integer> hm = new HashMap<>();
        hm.put("key1", 12);
        hm.put("key4", 15);
        hm.put("key1", 35);
        
        System.out.println("Map :  "+ hm);
        
        hm.compute("key1", (key, val) -> val == null ? 1 : val + 1);
        hm.compute("key2", (key, val) -> val == null ? 5 : val + 5);
        
        hm.computeIfAbsent("key3", (val) -> 20 * 30);
        
        System.out.println("New Map : " + hm);
        
        Map<String, Integer> treeMap =  hm.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                (oldValue, newValue) -> newValue, LinkedHashMap::new));
        System.out.println("TreeMap is :" + treeMap);
        
        findCount("occurences");
    }
    
    

    private static void findCount(String word) {
       Map<Character, Integer> countMap = new LinkedHashMap<>();
       word.chars().mapToObj(x -> (char) x).
       forEach(ch -> {
           Integer count = countMap.get(ch);
           count = (count == null) ?  1 : ++count;
           countMap.put(ch,  count);
       });
       
       System.out.println("Roopppppps");
       StringBuilder cntStr = new StringBuilder();
       countMap.entrySet().stream().forEach( e -> cntStr.append(e.getKey()).append(e.getValue()));
       System.out.println(cntStr.toString());
       
       List<Character> list = new ArrayList<>();
       for(Character ch : word.toCharArray()) {
           list.add(ch);
       }
       //Arrays.asList(word).stream()
       System.out.println("Different");
       
       Map<Character, Integer> listMap = list.stream()
            .collect(Collectors.toMap(x -> (char)x , x -> 1, (oV, nV) -> oV + 1, LinkedHashMap::new));
       StringBuilder cntStr1 = new StringBuilder();
       countMap.entrySet().stream().forEach( e -> cntStr1.append(e.getKey()).append(e.getValue()));
       System.out.println(cntStr1.toString());    
       
       String s1 = "hello";
       String s2 = "hello";
       String s3 = s1.toUpperCase() + "WORLD";
       s1 = s3;
       System.out.println(s1 + " , " + s2 + " , " + s3);
       
       Integer i = new Integer(10); 
       Integer j = new Integer(20); 
       swap(i, j); 
       System.out.println("i = " + i + ", j = " + j); 
       
    }   
    
    public static void swap(Integer i, Integer j)  
    { 
       Integer temp = new Integer(i); 
       i = j; 
       j = temp; 
    } 

    private static void printList(List filtered) {
        Iterator itr = filtered.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}
