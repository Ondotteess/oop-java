package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class PrintNum extends Command {
    @Override
    public void apply(Context ctx) {
        System.out.println(ctx.stack.pop());
    }
}
