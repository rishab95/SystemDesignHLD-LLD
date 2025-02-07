package Coding.LinkedIn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> result;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        flatten(nestedList);
        index = 0;
    }

    private void flatten(List<NestedInteger> nestedList){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                result.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return result.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < result.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
