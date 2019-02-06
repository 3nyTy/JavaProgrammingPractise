package StacksQueues;

public class Question {
    public static void main(String[] args) {
        
    
    int capacity_per_substack = 5;
    SetOfStacks set = new SetOfStacks(capacity_per_substack);
    for (int i = 0; i < 34; i++) {
        set.push(i);
    }
    System.out.println("PopAtIndex :" + set.popAt(2));
    /*for (int i = 0; i < 35; i++) {
        System.out.println("Popped " + set.pop());
    } */
    
   /* for (int i = 0; i < 35; i++) {
        System.out.println(set.peek());
    }*/
            
    }
}
