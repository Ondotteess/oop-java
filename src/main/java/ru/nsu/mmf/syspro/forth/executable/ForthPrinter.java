package ru.nsu.mmf.syspro.forth.executable;

import java.io.PrintStream;

public class ForthPrinter implements Printer {

    private final PrintStream out;

    public ForthPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(String line) {
        out.print(line);
    }

    @Override
    public void println(String line) {
        out.println(line);
    }

}
