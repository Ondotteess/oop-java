package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class PrintDebug extends Command {
    public void apply(Context ctx) {
        if (ctx.stack.size() == 0) {
            throw new RuntimeException("Error: stack is empty");
        } else {
            System.out.print("Stack: ");
            for(int i = 0; i < ctx.stack.get_size(); ++i) {
                System.out.print(ctx.stack.stack[i] + " ");
            }
            System.out.println();
        }
    }
}
