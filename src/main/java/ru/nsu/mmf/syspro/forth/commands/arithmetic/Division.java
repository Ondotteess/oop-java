package ru.nsu.mmf.syspro.forth.commands.arithmetic;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;
import ru.nsu.mmf.syspro.forth.excepiton.*;

public class Division implements Command {

    @Override
    public void apply(Context ctx) {
        int first = ctx.pop();
        int second = ctx.pop();

        if (first == 0) throw new ForthException("Trying to division by zero");

        ctx.push(second / first);
    }
}
