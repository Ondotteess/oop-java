package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Dup extends Command {
    @Override
    public void apply(Context ctx) {
        ctx.stack.push(ctx.stack.get_first());
    }
}
