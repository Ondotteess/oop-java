public class Parser {
    public void parse (String command){
        String[] tokens = command.split(" ");
        for (String token : tokens){
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
        String[] ops = {"dup", "drop", "swap", "rot", "emit", "cr", "exit"};
        for (String op : ops){
            if (command.equals(op)){
                return true;
            }
        }
        return false;
    }

    Mystack stack = new Mystack();
    Operators ops = new Operators(stack);
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
                default -> System.err.println("Unknown operator exception");
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
                default -> System.err.println("Unknown command exception");
                //TODO: make " ." " command
            }
        }
    }
}
