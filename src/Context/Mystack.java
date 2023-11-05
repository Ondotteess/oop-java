package Context;

public class Mystack {
    private int size = 0;
    private int capacity = 1;
    public int[] stack;

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
        }

    }

    public int get_first(){
        if (size < 1) System.exit(0);
        return this.stack[0];
    }
    public int get_second(){
        if (size < 2) System.exit(0);
        return this.stack[1];
    }
    public int get_third(){
        if (size < 3) System.exit(0);
        return this.stack[2];
    }

    public int pop() {
        if (this.size == 0) {
            //throw new ForthException("Error: stack is empty");
            throw new RuntimeException("");
        } else {
            if (this.size <= this.capacity / 2) {
                this.resize('-');
            }

            return this.stack[--this.size];
        }
    }
    public void push(int num) {
        if (this.size == this.capacity) {
            resize('+');
        }

        this.stack[this.size++] = num;
    }

    public int get_size() {
        return this.size;
    }

    public int size() {
        return size;
    }
}
