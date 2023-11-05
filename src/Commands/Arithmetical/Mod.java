package Commands.Arithmetical;

import Commands.Command;
import Context.Context;
import Context.Mystack;

public class Mod extends Command {
    @Override
    public void apply(Context ctx){
        if (ctx.stack.get_size() < 2); // TODO: Exception
        int result = ctx.stack.get_second() % ctx.stack.get_first();
        ctx.stack.push(result);
    }
}
