import Commands.Arithmetical.*;
import Commands.Logical.*;
import Commands.StackCommands.*;
import Context.*;
import Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Fortherpretator {
    Context ctx = new Context(new Mystack());

    public void interpret(String line){
        List<Command> commands = get_commands(line);
        if (commands == null){return;}

        for (Command command : commands){
            command.apply(ctx);
        }
    }
    private List<Command> get_commands(String line) {
        List<Command> output = new ArrayList<>();

        List<String> tokens = List.of(line.split(" "));
        List<String> commands = tokens_modifier(tokens);

        for (String command : commands){
            Command cmd = get_command(command);
            output.add(cmd);
        }
        return output;
    }

    private List<String> tokens_modifier(List<String> tokens){
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()){
            String token = tokens.get(i);
            if (token.equals(".\"")){
                StringBuilder sb = new StringBuilder();
                token = tokens.get(i++);
                while (token.charAt(token.length() - 1) != '"' || i < tokens.size()) {
                    sb.append(token);
                    token = tokens.get(i++);
                }
                output.add(sb.toString());
            } else {
                output.add(token);
            }
            i++;
        }
        return output;
    }

    private Command get_command(String cmd){
        return switch (cmd){
            case "/" -> new Division();
            case "-" -> new Minus();
            case "%" -> new Mod();
            case "*" -> new Multiply();
            case "+" -> new Plus();
            case "=" -> new Equal();
            case ">" -> new Larger();
            case "<" -> new Less();
            case "cr" -> new Cr();
            case "drop" -> new Drop();
            case "dup" -> new Dup();
            case "emit" -> new Emit();
            case "exit" -> new Exit();
            case "." -> new PrintNum();
            case ".\"" -> new PrintString(cmd);
            case "rot" -> new Rot();
            case "swap" -> new Swap();
            case "print" -> new PrintDebug();

            default -> {
                if (isInteger(cmd)) {
                    yield new Push(cmd);
                } else throw new IllegalStateException("Unexpected value: " + cmd);
            }
        };
    }
    boolean isInteger(String token) {
        return token.matches("-?\\d+");
    }
}
