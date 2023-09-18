interface Command {
    void apply(Context ctx);

    String print();
}