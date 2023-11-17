package ru.nsu.mmf.syspro.forth.commands.print;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;
import ru.nsu.mmf.syspro.forth.excepiton.ForthException;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PrintDebug implements Command {

    public void apply(Context ctx) {
        if (ctx.getSize() == 0) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");

            for (Integer element : ctx.getStack()) {
                System.out.print(element + " ");
            }

        }
    }

}