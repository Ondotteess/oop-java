public class Left implements Command{
    @Override
    public void apply(Context ctx) {
        if (ctx.pos > 0) {
            ctx.pos--;
        } else {
            System.err.println("Out of bounds: pos = 0.");
        }
    }

    @Override
    public String print() {
        return "ctx.pos--;";
    }
}
