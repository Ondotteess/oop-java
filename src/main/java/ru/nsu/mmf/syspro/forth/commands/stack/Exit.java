package ru.nsu.mmf.syspro.forth.commands.stack;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;
import ru.nsu.mmf.syspro.forth.excepiton.ForthException;

public class Exit implements Command {

    @Override
    public void apply(Context ctx) {
        ctx.stopWorking();
    }
}
