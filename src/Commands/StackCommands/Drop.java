package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Drop extends Command {
    @Override
    public void apply(Context ctx) {
        ctx.stack.pop();
    }
}
