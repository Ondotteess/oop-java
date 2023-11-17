package ru.nsu.mmf.syspro.forth.executable;

import ru.nsu.mmf.syspro.forth.excepiton.ForthException;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        execute(System.out);
    }

    public static void execute(PrintStream out) {
        Scanner scanner = new Scanner(System.in);
        ForthInterpretator forth = new ForthInterpretator(out);

        while (true) {
            boolean isWorking = true;
            try {
                String line = scanner.nextLine();
                isWorking = forth.interpret(line);
                if (!isWorking) return;
            } catch (ForthException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}