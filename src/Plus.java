class Plus implements Command {

    @Override
    public void apply(Context ctx) {
        ctx.cells[ctx.pos]++;
    }

    @Override
    public String print() {
        return "ctx.cells[ctx.pos]++;";
    }

}