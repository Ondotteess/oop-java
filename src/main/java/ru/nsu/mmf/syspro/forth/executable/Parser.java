package ru.nsu.mmf.syspro.forth.executable;

import ru.nsu.mmf.syspro.forth.commands.Command;
import ru.nsu.mmf.syspro.forth.commands.arithmetic.*;
import ru.nsu.mmf.syspro.forth.commands.logic.Equal;
import ru.nsu.mmf.syspro.forth.commands.logic.Greater;
import ru.nsu.mmf.syspro.forth.commands.logic.Less;
import ru.nsu.mmf.syspro.forth.commands.print.*;
import ru.nsu.mmf.syspro.forth.commands.stack.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<Command> parse(String line) {
        List<Command> output = new ArrayList<>();

        List<String> tokens = List.of(line.split(" "));
        List<String> commands = tokensModifier(tokens);

        for (String command : commands) {
            Command cmd = getCommand(command);
            output.add(cmd);
        }
        return output;
    }

    private List<String> tokensModifier(List<String> tokens) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if (!token.equals(".\"") && !token.isEmpty()) {
                output.add(token);
            } else if (token.equals(".\"")) {
                StringBuilder sb = new StringBuilder(token);
                while (true) {
                    token = tokens.get(++i);
                    if (token.isEmpty()) {
                        sb.append(" ");
                        continue;
                    }
                    char c = token.charAt(token.length() - 1);
                    if (c == '"') {
                        sb.append(" ").append(token);
                        output.add(sb.toString().trim());
                        break;
                    }
                    sb.append(" ").append(token);
                }

            }
            i++;
        }
        return output;
    }

    private Command getCommand(String cmd) {
        return switch (cmd.split(" ")[0]) {
            case "/" -> new Division();
            case "-" -> new Minus();
            case "mod" -> new Mod();
            case "*" -> new Multiply();
            case "+" -> new Plus();
            case "=" -> new Equal();
            case ">" -> new Greater();
            case "<" -> new Less();
            case "cr" -> new Cr();
            case "drop" -> new Drop();
            case "dup" -> new Dup();
            case "emit" -> new Emit();
            case "exit" -> new Exit();
            case "over" -> new Over();
            case "." -> new PrintNum();
            case ".\"" -> new PrintString(stripString(cmd));
            case "rot" -> new Rot();
            case "swap" -> new Swap();
            case "print" -> new PrintDebug();

            default -> {
                if (isInteger(cmd)) {
                    yield new Push(Integer.parseInt(cmd));
                } else throw new IllegalStateException("Unexpected value: " + cmd);
            }
        };
    }

    private String stripString(String cmd) {
        if (cmd != null && cmd.length() >= 4) {
            cmd = cmd.substring(3, cmd.length() - 1);
        } else {
            cmd = "";
        }
        return cmd;
    }

    private boolean isInteger(String token) {
        return token.matches("-?\\d+");
    }

}
