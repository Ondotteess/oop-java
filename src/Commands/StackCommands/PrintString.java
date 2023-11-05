package Commands.StackCommands;


import Commands.Command;
import Context.Context;

public class PrintString extends Command {
    String str;
    public PrintString(String str){
        this.str = str;
    }
    @Override
    public void apply(Context ctx){
        System.out.println(str);
    }

}
