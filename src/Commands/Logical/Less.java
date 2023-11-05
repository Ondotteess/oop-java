package Commands.Logical;

import Commands.Command;
import Context.Context;
public class Less extends Command {
    @Override
    public void apply(Context ctx){
        if (ctx.stack.get_size() < 2); // TODO: Exception
        int result = ctx.stack.get_second() < ctx.stack.get_first() ? 1 : 0;
        ctx.stack.push(result);
    }
}
