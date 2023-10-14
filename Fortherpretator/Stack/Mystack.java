
package Fortherpretator.Stack;

import Fortherpretator.Executable.ForthException;

public class Mystack {
    private int size = 0;
    private int capacity = 1;
    private int[] stack;

    public Mystack() {
        this.stack = new int[this.capacity];
    }

    private void resize(char param) {
        int[] newStack;
        if (param == '+') {
            this.capacity *= 2;
            newStack = new int[this.capacity];
            if (this.size >= 0) {
                System.arraycopy(this.stack, 0, newStack, 0, this.size);
            }

            this.stack = newStack;
        } else if (param == '-') {
            this.capacity /= 2;
            newStack = new int[this.capacity];
            if (this.size >= 0) {
                System.arraycopy(this.stack, 0, newStack, 0, this.size);
            }

            this.stack = newStack;
        } else {
            System.err.println("Resize parameter error");
            System.exit(0);
        }

    }

    public void push(int num) {
        if (this.size == this.capacity) {
            resize('+');
        }

        this.stack[this.size++] = num;
    }

    public void dup() { push(this.top()); }

    public void over() {push(stack[this.size - 2]); }

    public void print_pop() {
        System.out.println(this.pop());
    }

    public void swap() {
        if (this.size < 2) {
            throw new ForthException("Error: not enough numbers");
        } else {
            int first = this.top();
            this.stack[this.size - 1] = this.stack[this.size - 2];
            this.stack[this.size - 2] = first;
        }
    }

    public void rot() {
        if (this.size < 3) {
            throw new ForthException("Error: not enough numbers");
        } else {
            int first = this.stack[this.size - 1];
            int second = this.stack[this.size - 2];
            int third = this.stack[this.size - 3];
            this.stack[this.size - 1] = second;
            this.stack[this.size - 2] = third;
            this.stack[this.size - 3] = first;
        }
    }

    public void emit() {
        char c = (char)this.pop();
        System.out.println(c);
    }

    public void cr() {
        System.out.print("\n");
    }

    public int pop() {
        if (this.size == 0) {
            throw new ForthException("Error: stack is empty");
        } else {
            if (this.size <= this.capacity / 2) {
                this.resize('-');
            }

            return this.stack[--this.size];
        }
    }

    public void drop() {
        if (this.size == 0) {
            throw new ForthException("Error: stack is empty");
        } else {
            if (this.size <= this.capacity / 2) {
                this.resize('-');
            }

            --this.size;
        }
    }

    public int top() {
        if (this.size == 0) {
            throw new ForthException("Error: stack is empty");
        } else {
            return this.stack[this.size - 1];
        }
    }

    public int second() {
        if (this.size < 2) {
            throw new ForthException("Error: not enough numbers");
        } else {
            return this.stack[this.size - 2];
        }
    }

    public void exit() {
        System.exit(0);
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public void print() {
        if (this.size == 0) {
            throw new ForthException("Error: stack is empty");
        } else {
            System.out.print("Stack: ");
            for(int i = 0; i < size; ++i) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
