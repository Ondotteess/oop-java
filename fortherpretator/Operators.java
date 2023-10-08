public class Operators {
    private Mystack stack;
    public Operators(Mystack stack){
        this.stack = stack;
    }
    public void plus(){
        int result = stack.second() + stack.top();
        stack.pop();
        stack.pop();
        stack.push(result);
    }
    public void minus(){
        int result = stack.second() - stack.top();
        stack.pop();
        stack.pop();
        stack.push(result);
    }
    public void division(){
        int result = stack.second() / stack.top();
        stack.pop();
        stack.pop();
        stack.push(result);
    }
    public void multiply(){
        int result = stack.second() * stack.top();
        stack.pop();
        stack.pop();
        stack.push(result);
    }
    public void mod(){
        int result = stack.second() % stack.top();
        stack.pop();
        stack.pop();
        stack.push(result);
    }

    public void larger(){
        int result = stack.second() > stack.top() ? 1 : 0;
        stack.pop();
        stack.pop();
        stack.push(result);

    }
    public void less(){
        int result = stack.second() < stack.top() ? 1 : 0;
        stack.pop();
        stack.pop();
        stack.push(result);
    }
    public void equal(){
        int result = stack.second() == stack.top() ? 1 : 0;
        stack.pop();
        stack.pop();
        stack.push(result);
    }

}
