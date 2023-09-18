class Print implements Command {

    @Override
    public void apply(Context ctx) {
        System.out.println(ctx.cells[ctx.pos]);
    }

    @Override
    public String print() {
        return "System.out.println(ctx.cells[ctx.pos])";
    }
}