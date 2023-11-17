package ru.nsu.mmf.syspro.forth.commands.stack;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class Push implements Command {

    final int num;

    public Push(int num){
        this.num = num;
    }

    @Override
    public void apply(Context ctx) {
        ctx.push(num);
    }
}
