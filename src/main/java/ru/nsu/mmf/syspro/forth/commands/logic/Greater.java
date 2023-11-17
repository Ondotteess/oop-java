package ru.nsu.mmf.syspro.forth.commands.logic;


import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;
public class Greater implements Command {

    public void apply(Context ctx) {
        int result = ctx.pop() > ctx.pop() ? 1 : 0;
        ctx.push(result);
    }
}
