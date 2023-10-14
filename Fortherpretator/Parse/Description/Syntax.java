package Fortherpretator.Parse.Description;

import Fortherpretator.Stack.Mystack;
import java.util.ArrayList;

public class Syntax {
    private final Mystack stack;

    public Syntax(Mystack stack1) {
        stack = stack1;
    }

    boolean elseincommand(String command) {
        String[] tokens = command.split(" ");
        int i = 0;
        int count = 1;
        String token = tokens[++i];

        while (i < tokens.length) {
            if (token.equals("if")) ++count;
            if (token.equals("else") || token.equals("then")) {
                --count;
                if (count == 0) {
                    return true;
                }
            }
            token = tokens[++i];
        }
        return false;
    }

    int elseposition(String command) {
        String[] tokens = command.split(" ");
        int i = 0;
        int count = 1;
        String token = tokens[++i];

        while (i < tokens.length) {
            if (token.equals("if")) ++count;
            if (token.equals("then")) --count;
            if (token.equals("else") && count - 1 == 0) return i;

            token = tokens[++i];
        }

        return -1;
    }

    public String branches(String branch) {
        String command = "";
        int first = stack.top();
        String[] tokens;
        StringBuilder sb;
        int i = 0;
        int count = 1;
        String token;
        if (first != 0) {
            tokens = branch.split(" ");
            token = tokens[++i];
            sb = new StringBuilder();

            while (i < tokens.length) {
                if (token.equals("if") || token.equals("do")) ++count;

                if (token.equals(";") || token.equals("else")) {
                    --count;
                    if (token.equals(";")) sb.append(" ").append(";");
                    if (count == 0) break;
                }
                sb.append(" ").append(token);
                token = tokens[++i];
            }
            command = sb.toString();
            return command;
        } else if (first == 0 && elseincommand(branch)) {
            tokens = branch.split(" ");
            sb = new StringBuilder();
            i = elseposition(branch);
            token = tokens[++i];

            while (i < tokens.length) {
                if (token.equals("if") || token.equals("do")) ++count;
                if (token.equals("then")) {
                    --count;
                    if (count == 0) {
                        break;
                    }
                }
                sb.append(" ").append(token);
                token = tokens[++i];
            }
            command = sb.toString().trim();
            return command;
        } else {
            System.out.println("Kill yourself it wont be painfull");
            System.out.println(command);
            return command;
        }
    }

    public int ifounder(String[] tokens) {
        int i = 0;
        int count = 0;
        String token = tokens[i];

        while(i < tokens.length) {
            if (token.equals("i") && count == 0) return i;
            if (token.equals("do"))   ++count;
            if (token.equals("loop")) --count;

            token = tokens[++i];
        }

        return -1;
    }

    public ArrayList<String> cycle(String cycle) {
        String command = "";
        int first = stack.pop();
        int second = stack.pop();
        String[] tokens = cycle.split(" ");
        int j = 1;
        String token = tokens[j];
        int count = 1;

        StringBuilder sb = new StringBuilder();
        while (j < tokens.length) {
            if (token.equals("if") || token.equals("do")) ++count;

            if (token.equals("loop") || token.equals("then")) {
                --count;
                if (count == 0) {
                    break;
                }
            }

            sb.append(" ").append(token);
            token = tokens[++j];
        }

        command = sb.toString().trim();
        int iindex = ifounder(command.split(" "));

        ArrayList<String> expanded = new ArrayList();

        for(int i = first; i < second; ++i) {
            tokens = command.split(" ");
            tokens[iindex] = String.format("%d", i);
            String cmd = String.join(" ", tokens);
            expanded.add(cmd);
        }

        return expanded;
    }

    public void commands(String command) {
    }

    public void variable(String command) {
    }

    public void arrays() {
    }
}
