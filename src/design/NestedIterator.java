package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int currPosition;
    int size;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        addNestedList(list, nestedList);
        
        currPosition = 0;
        size = list.size();
    }

    private void addNestedList(List<Integer> list, List<NestedInteger> nestedList) {
        for(NestedInteger eachList : nestedList) {
            if(eachList.isInteger()) {
                list.add(eachList.getInteger());
            } else {
                addNestedList(list, eachList.getList());
                
            }
        }
        
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return currPosition < size;
    }

    @Override
    public Integer next() {
        // TODO Auto-generated method stub
        return list.get(currPosition++);
    }

}
