package ru.nsu.mmf.syspro.forth.commands;

import ru.nsu.mmf.syspro.forth.context.Context;

public interface Command {

    void apply(Context ctx);

}
