package ru.nsu.mmf.syspro.forth.context;

import ru.nsu.mmf.syspro.forth.executable.ForthPrinter;
import ru.nsu.mmf.syspro.forth.executable.Printer;

import java.io.PrintStream;
import java.util.ArrayDeque;


public class Context {

    private final Mystack stack;

    private final Printer printer;

    private boolean isWorking;


    public Context(PrintStream out) {
        this.printer = new ForthPrinter(out);
        this.stack = new Mystack();
        this.isWorking = true;
    }

    public void push(int num){
        stack.push(num);
    }

    public int pop(){
        return stack.pop();
    }

    public int getSize(){
        return stack.getSize();
    }

    public ArrayDeque<Integer> getStack() {
        return stack.getStack();
    }

    public void print(String line) {
        printer.print(line);
    }

    public void println(String line) {
        printer.println(line);
    }

    public boolean isWorking(){
        return isWorking;
    }

    public void stopWorking(){
        isWorking = false;
    }
}
