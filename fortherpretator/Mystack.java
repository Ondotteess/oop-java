public class Mystack {
    private int size;
    private int capacity;
    private int[] stack;

    public Mystack(){
        this.size = 0;
        this.capacity = 1;
        this.stack = new int[capacity];
    }

    private void resize(char param) {
        if (param == '+') {
            capacity *= 2;
            int[] newStack = new int[capacity];
            for (int i = 0; i < size; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        } else if (param == '-') {
            capacity /= 2;
            int[] newStack = new int[capacity];
            for (int i = 0; i < size; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        } else {
            System.err.println("Resize parameter error");
            System.exit(0);
        }
    }

    public void push(int num){
        if (size == capacity) resize('+');
        stack[size++] = num;
    }

    public void dup(){
        if (size == capacity) resize('+');
        stack[size++] = top();
    }

    public void swap(){
        if (size < 2) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        int first = top();
        stack[size - 1] = stack[size - 2];
        stack[size - 2] = first;
    }

    public void rot(){
        if (size < 3) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        int first = stack[size - 1];
        int second = stack[size - 2];
        int third = stack[size - 3];
        stack[size - 1] = second;
        stack[size - 2] = third;
        stack[size - 3] = first;
    }

    public void emit(){
        char c = (char) pop();
        System.out.println(c);
    }

    public void cr(){
        System.out.println("\n");
    }

    public int pop() {
        if (size == 0) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        if (size <= capacity / 2) resize('-');
        return stack[--size];
    }

    public void drop(){
        if (size == 0) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        if (size <= capacity / 2) resize('-');
        size--;

    }

    public int top(){
        if (size == 0) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        return stack[size - 1];
    }

    public int second(){
        if (size < 2) {
            System.err.println("Stack is empty");
            System.exit(0);
        }
        return stack[size - 2];
    }

    public void exit(){
        System.exit(0);
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i < size; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

}
