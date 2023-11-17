package ru.nsu.mmf.syspro.forth.executable;

import ru.nsu.mmf.syspro.forth.context.*;
import ru.nsu.mmf.syspro.forth.commands.Command;

import java.io.PrintStream;
import java.util.List;

public class ForthInterpretator {

    private final Context ctx;

    private final Parser parser;

    public ForthInterpretator(PrintStream out) {
        this.ctx = new Context(out);
        this.parser = new Parser();
    }

    public boolean interpret(String line) {
        List<Command> commands = parser.parse(line);

        for (Command command : commands) {
            if (ctx.isWorking()) command.apply(ctx);
        }

        return ctx.isWorking();
    }


}
