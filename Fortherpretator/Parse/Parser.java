
package Fortherpretator.Parse;

import Fortherpretator.Executable.ForthException;
import Fortherpretator.Parse.Description.Syntax;
import Fortherpretator.Stack.Mystack;
import Fortherpretator.Stack.Commands.Operators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private final Mystack stack;
    private final Operators ops;
    private final Syntax syntax;

    public static List<String> tokens_modifier(String[] tokens) {
        int i = 0;

        List<String> output = new ArrayList<>();
        while (i < tokens.length) {
            String token = tokens[i];
            if (!token.equals("if") && !token.equals("do") && !token.equals(":") && !token.equals(".\"")) {
                output.add(token);
            } else {
                StringBuilder sb;
                if (!token.equals("if") && !token.equals("do")) {
                    if (token.equals(":")) {
                        sb = new StringBuilder(token);

                        while(i < tokens.length - 1) {
                            token = tokens[++i];
                            sb.append(" ").append(token);
                        }

                        output.add(sb.toString());
                    } else if (token.equals(".\"")) {
                        sb = new StringBuilder(token);

                        while(true) {
                            token = tokens[++i];
                            char c = token.charAt(token.length() - 1);
                            if (c == '"') {
                                sb.append(" ").append(token);
                                output.add(sb.toString().trim());
                                break;
                            }
                            sb.append(" ").append(token);
                        }
                    }
                } else {
                    sb = new StringBuilder();
                    int count = 1;

                    while(true) {
                        sb.append(" ").append(token);
                        if (token.equals("if") || token.equals("do")) ++count;


                        if (token.equals(";")) {
                            --count;
                            if (count == 1) {
                                sb.append(" ");
                                output.add(sb.toString().trim());
                                break;
                            }
                        }
                        token = tokens[++i];
                    }
                }
            }
            i++;
        }

        return output;
    }

    public void parse(String command) {
        String[] tokens = command.trim().split(" ");
        String[] newtokens = tokens_modifier(tokens).toArray(new String[0]);

        for(String token : newtokens) {
            brancher(token);
        }

    }

    boolean isInteger(String token) {
        return token.matches("-?\\d+");
    }

    boolean isOperator(String token) {
        String[] ops = new String[]{"+", "-", "*", "/", ">", "<", "=", "mod"};
        for(String op: ops) {
            if (token.equals(op)) return true;
        }
        return false;
    }

    boolean isCommand(String command) {
        String[] ops = {"dup", "drop", "swap", "rot", "emit", "cr", "exit", "print", ".", "over", ".\""};
        String command1 = command.split(" ")[0];
        for (String op : ops) {
            if (command1.equals(op)) return true;
        }
        return false;
    }

    boolean isSyntax(String command) {
        String first = command.split(" ")[0];
        String[] syntax = {"if", "do", ":", "variable"};
        for(String s : syntax) {
            if (first.equals(s)) return true;
        }
        return false;
    }

    public Parser(Mystack stack, Operators ops, Syntax syntax) {
        this.stack = stack;
        this.ops = ops;
        this.syntax = syntax;
    }

    public void stringPrinter(String token) {
        token = token.substring(2, token.length() - 1);
        System.out.print(token.trim());
    }

    public void brancher(String token) {
        if (this.isInteger(token)) {
            this.stack.push(Integer.parseInt(token));
        } else if (this.isOperator(token)) {
            if (this.stack.size() < 2) {
                throw new ForthException("Error: not enough numbers on stack");
            }

            switch (token) {
                case "+" -> ops.plus();
                case "-" -> ops.minus();
                case "*" -> ops.multiply();
                case "/" -> ops.division();
                case "mod" -> ops.mod();
                case ">" -> ops.larger();
                case "<" -> ops.less();
                case "=" -> ops.equal();
                default -> throw new ForthException("Error: unknown operator exception");
            }
        } else if (this.isCommand(token)) {
            switch (token.split(" ")[0]) {
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
                case ".\"" -> stringPrinter(token);
                default -> {
                    System.out.println(token);
                    throw new ForthException("Unknown command exception");
                }
            }
        } else {
            if (!this.isSyntax(token)) {
                if (token.isEmpty()) {
                    return;
                }

                System.out.println(token);
                throw new ForthException("Unknown token exception");
            }

            switch (token.split(" ")[0]) {
                case "if" -> parse(this.syntax.branches(token));
                case "do" -> {
                    ArrayList<String> expanded = this.syntax.cycle(token);
                    for (String cmd : expanded) {parse(cmd);
                    }
                }
                case "variable" -> syntax.variable(token);
                case ":" -> syntax.commands(token);
                default ->
                        throw new ForthException("Error: unknown syntax exception");
            }
        }

    }
}
