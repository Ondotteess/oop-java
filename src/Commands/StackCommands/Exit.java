package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Exit extends Command {
    @Override
    public void apply(Context ctx) {
        throw new RuntimeException(); // TODO: Stop intrerpret exception
    }
}
