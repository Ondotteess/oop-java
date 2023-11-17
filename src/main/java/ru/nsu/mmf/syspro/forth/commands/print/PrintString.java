package ru.nsu.mmf.syspro.forth.commands.print;


import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.context.Context;

public class PrintString implements Command {

    final String str;

    public PrintString(String str){
        this.str = str;
    }

    @Override
    public void apply(Context ctx) {
        ctx.print(str);
    }
}
