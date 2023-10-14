

package Fortherpretator.Stack.Commands;

import Fortherpretator.Executable.ForthException;
import Fortherpretator.Stack.Mystack;

public class Operators {
    private final Mystack stack;

    public Operators(Mystack stack) {
        this.stack = stack;
    }

    public void plus() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = stack.second() + stack.top();
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void minus() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = this.stack.second() - this.stack.top();
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void division() {
        if (stack.size() < 2)      throw new ForthException("Error: not enough numbers");
        if (this.stack.top() == 0) throw new ForthException("Error: division by zero");
        int result = stack.second() / stack.top();
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);

    }

    public void multiply() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = stack.second() * stack.top();
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void mod() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = stack.second() % stack.top();
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void larger() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = stack.second() > stack.top() ? 1 : 0;
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void less() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = this.stack.second() < this.stack.top() ? 1 : 0;
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }

    public void equal() {
        if (stack.size() < 2) throw new ForthException("Error: not enough numbers");
        int result = this.stack.second() == this.stack.top() ? 1 : 0;
        this.stack.pop();
        this.stack.pop();
        this.stack.push(result);
    }
}
