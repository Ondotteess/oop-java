package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Swap extends Command {
    @Override
    public void apply(Context ctx) {
        int first = ctx.stack.get_first();
        int second = ctx.stack.get_second();

        ctx.stack.pop();
        ctx.stack.pop();

        ctx.stack.push(first);
        ctx.stack.push(second);
    }
}
