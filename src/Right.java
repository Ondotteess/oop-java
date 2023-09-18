class Right implements Command {
    @Override
    public void apply(Context ctx) {
        ctx.pos++;
    }

    @Override
    public String print() {
        return "ctx.pos++;";
    }
}