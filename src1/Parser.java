import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Mystack stack;
    private Operators ops;
    private Syntax syntax;

    public static List<String> tokens_modifier(String[] tokens) {
        int i = 0;
        List<String> output = new ArrayList<>();
        while (i < tokens.length) {
            String token = tokens[i];

            if (!token.equals("if") && !token.equals("do") && !token.equals(":")) {
                output.add(token);

            } else if (token.equals("if") || token.equals("do")) {
                StringBuilder sb = new StringBuilder();        // TODO: сдвинь сб на верх
                int count = 1;
                while (i < tokens.length - 1 || (!token.equals(";") && count != 1)) {
                    sb.append(" ").append(token);

                    if (token.equals("if") || token.equals("do")) count++;

                    if (token.equals(";")) {
                        count--;
                        if (count == 1) break;
                    }
                    token = tokens[++i];
                }
                sb.append(" ");
                output.add(sb.toString().trim());
                System.out.println(output);
                System.exit(0);
            } else if (token.equals(":")) {
                StringBuilder sb = new StringBuilder(token);
                while (i < tokens.length - 1) {
                    token = tokens[++i];
                    sb.append(" ").append(token);
                }
                output.add(sb.toString());
            }
            i++;
        }
        return output;
    }

    public void parse (String command){
        String[] tokens = command.split(" ");
        String[] newtokens = tokens_modifier(tokens).toArray(new String[0]);
        for (String token : newtokens){
            //System.out.println(token);
            brancher(token);
        }
    }



    boolean isInteger(String token){
        return token.matches("-?\\d+");
    }

    boolean isOperator(String token){
        String[] ops = {"+", "-", "*", "/", ">", "<", "="};
        for (String op : ops){
            if (token.equals(op)){
                return true;
            }
        }
        return false;
    }

    boolean isCommand(String command){
        String[] ops = {"dup", "drop", "swap", "rot", "emit", "cr", "exit", "print", ".", "over"};
        for (String op : ops){
            if (command.equals(op)) return true;
        }
        return false;
    }

    boolean isSyntax(String command){
        String first = command.split(" ")[0];
        String[] syntax = {"if", "do", ":", "variable"};
        for (String s : syntax) {
            if (first.equals(s)) return true;
        }
        return false;
    }

    public Parser(Mystack stack, Operators ops, Syntax syntax) {
        this.stack = stack;
        this.ops = ops;
        this.syntax = syntax;
    }


    public void brancher(String token){                     //TODO: RENAME BLYAD
        if (isInteger(token)){
            stack.push(Integer.parseInt(token));
        } else if (isOperator(token)){
            switch (token){
                case "+" -> ops.plus();
                case "-" -> ops.minus();
                case "*" -> ops.multiply();
                case "/" -> ops.division();
                case "mod" -> ops.mod();
                case ">" -> ops.larger();
                case "<" -> ops.less();
                case "=" -> ops.equal();
                default -> {
                    System.err.println("Unknown operator exception");
                    System.exit(0);
                }
            }
        } else if (isCommand(token)) {
            switch (token){
                case "dup" -> stack.dup();
                case "drop" -> stack.drop();
                case "swap" -> stack.swap();
                case "rot" -> stack.rot();
                case "emit" -> stack.emit();
                case "cr" -> stack.cr();
                case "exit" -> stack.exit();
                case "over" -> stack.over();
                case "." -> stack.print_pop();
                case "print" -> stack.print();
                default -> {
                    System.err.println("Unknown command exception");
                    // System.exit(0);
                }
                // TODO: make " ." " command                X
                // TODO: make if-else-then branches
                // TODO: make do loops
                // TODO: make custom commands
                // TODO: make variables
                // TODO: make arrays
            }
        } else if (isSyntax(token)){
            String first = token.split(" ")[0];
            switch (first) {
                case "if" -> parse(syntax.branches(token));
                case "do" -> syntax.cycle(token);
                case "variable" -> syntax.variable(token);
                case ":" -> syntax.commands(token);
                default -> {
                    System.out.println("IDK kill yourself");
                }
            }
        } else {
            System.err.println("Unknown command exception");
            System.exit(0);
        }
    }
}
