package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Emit extends Command {
    @Override
    public void apply(Context ctx) {
        char c = (char)ctx.stack.pop();
        System.out.println(c);
    }
}
