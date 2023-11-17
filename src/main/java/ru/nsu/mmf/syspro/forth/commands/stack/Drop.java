package ru.nsu.mmf.syspro.forth.commands.stack;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Drop implements Command {

    @Override
    public void apply(Context ctx) {
        ctx.pop();
    }
}
