package ru.nsu.mmf.syspro.forth.commands.arithmetic;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Minus implements Command {

    @Override
    public void apply(Context ctx) {
        int first = ctx.pop();
        int second = ctx.pop();

        ctx.push(second - first);
    }
}
