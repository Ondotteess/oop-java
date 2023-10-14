package Fortherpretator.Executable;

import Fortherpretator.Parse.Description.Syntax;
import Fortherpretator.Parse.Parser;
import Fortherpretator.Stack.Commands.Operators;
import Fortherpretator.Stack.Mystack;

public class Forth {
    private final Mystack stack = new Mystack();
    private final Operators ops = new Operators(stack);
    private final Syntax syntax = new Syntax(stack);
    private final Parser parser = new Parser(stack, ops, syntax);

    public Forth(){

    };

    public void execute(String line){
        parser.parse(line);
    }

}
