package Commands;

import Context.Context;

public abstract class Command {
    public abstract void apply(Context ctx);

    public void apply(Context ctx, String additionalData) {
    }
}
