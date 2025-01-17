package Coding.LinkedIn;

import java.util.*;

/**
 * The problem asks us to design a customized stack structure, which is a common Last-In-First-Out (LIFO)
 * data structure with an added capability of retrieving and removing the maximum element it contains.
 * This stack should support the following operations:
 *
 * <p>
 * push(x): Add an element x to the top of the stack.
 * pop(): Remove the element at the top of the stack and return it.
 * top(): Return the element at the top of the stack without removing it.
 * peekMax(): Retrieve the maximum element in the stack without removing it.
 * popMax(): Retrieve the maximum element in the stack and remove it. If there are multiple instances
 * of the maximum element, only the top-most one should be removed.
 * The challenge lies in designing these operations to be time efficient, specifically requiring the
 * top call to be O(1) and all other calls to be O(log n) complexity.
 * <p/>
 */

public class MaxStack {
    // Construct 2 stacks, 1 for normal stack 1 for max stack.
    // Use DLL
    private List<Integer> stack;
    private TreeMap<Integer, List<Integer>> treeMap;

    public MaxStack() {
        stack = new LinkedList<>();
        treeMap = new TreeMap<>();
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public void push(int num) {
        int currentIter = stack.size();
        stack.add(num);
        // Update treeset with freq;
        // treeMap.computeIfAbsent(num, k -> new ArrayList<>().add(num));
    }
}
