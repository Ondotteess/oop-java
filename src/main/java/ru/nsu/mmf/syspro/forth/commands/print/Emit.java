package ru.nsu.mmf.syspro.forth.commands.print;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Emit implements Command {

    @Override
    public void apply(Context ctx) {
        char c = (char)ctx.pop();
        ctx.print(Character.toString(c));
    }
}
