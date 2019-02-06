package amazomn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ConstantRandomizedSet {
    /** Initialize your data structure here. 
     * @return */
    ArrayList<Integer> list;
    HashMap<Integer, Integer> valIndxMAp;
     
    public void RandomizedSet() {
        list = new ArrayList<>();
        valIndxMAp  = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valIndxMAp.containsKey(val)) {
            return false;
        } else {
            valIndxMAp.put(val, list.size());
            list.add(val);
            return true;
        }        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valIndxMAp.containsKey(val)) {
            return false;
        } else {
            int key = valIndxMAp.get(val);
            int lastElem = list.get(list.size() - 1);
            list.set(key, lastElem);
            valIndxMAp.remove(val);
            list.remove(list.size() -1);
            return true;
            
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random  random = new Random(); 
        return list.get(random.nextInt(list.size()));
        
    }

}
