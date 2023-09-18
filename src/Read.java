class Read implements Command {
    final int idx;
    final String command;
    final char c;
    public Read(int idx, String command) {
        this.idx = idx;
        this.command = command;
        this.c = command.charAt(idx+1);
    }

    @Override
    public void apply(Context ctx) {
        ctx.cells[ctx.pos] += c;
    }

    @Override
    public String print() {
        return "ctx.cells[ctx.pos] += c;";
    }
}
