package ru.nsu.mmf.syspro.forth.commands.stack;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Dup implements Command {

    @Override
    public void apply(Context ctx) {
        int num = ctx.pop();

        ctx.push(num);
        ctx.push(num);
    }
}
