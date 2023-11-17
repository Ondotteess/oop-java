package ru.nsu.mmf.syspro.forth.context;

import ru.nsu.mmf.syspro.forth.excepiton.ForthException;

import java.util.ArrayDeque;

public class Mystack {

    private final ArrayDeque<Integer> stack;

    public Mystack() {
        this.stack = new ArrayDeque<Integer>();
    }

    int pop() {
        if (stack.isEmpty()) throw new ForthException("Not enough numbers on stack.");
        return stack.pop();
    }

    void push(int num) {
        stack.push(num);
    }

    int getSize() {
        return stack.size();
    }

    public ArrayDeque<Integer> getStack() {
        return stack;
    }

}
