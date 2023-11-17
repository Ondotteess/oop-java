package ru.nsu.mmf.syspro.forth.commands.stack;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Swap implements Command {

    @Override
    public void apply(Context ctx) {
        int first = ctx.pop();
        int second = ctx.pop();

        ctx.push(first);
        ctx.push(second);
    }
}
