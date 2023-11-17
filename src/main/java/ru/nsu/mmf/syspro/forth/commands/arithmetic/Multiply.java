package ru.nsu.mmf.syspro.forth.commands.arithmetic;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Multiply implements Command {

    @Override
    public void apply(Context ctx) {
        int result = ctx.pop() * ctx.pop();
        ctx.push(result);
    }
}
