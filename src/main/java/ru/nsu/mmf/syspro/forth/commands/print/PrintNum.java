package ru.nsu.mmf.syspro.forth.commands.print;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class PrintNum implements Command {

    @Override
    public void apply(Context ctx) {
        ctx.print(String.valueOf(ctx.pop()));
    }
}
