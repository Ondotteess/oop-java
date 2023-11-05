package Commands.StackCommands;

import Commands.Command;
import Context.Context;

public class Push extends Command {
    int num;
    public Push(String num){
        this.num = Integer.parseInt(num);
    }
    @Override
    public void apply(Context ctx) {
        ctx.stack.push(num);
    }
}
